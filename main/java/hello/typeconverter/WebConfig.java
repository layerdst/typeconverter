package hello.typeconverter;

import hello.typeconverter.coverter.IntegerToStringConverter;
import hello.typeconverter.coverter.IpPortToStringConverter;
import hello.typeconverter.coverter.StringToInteger;
import hello.typeconverter.coverter.StringToIpPortConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry){
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());
        registry.addConverter(new StringToInteger());
        registry.addConverter(new IntegerToStringConverter());
    }

}
