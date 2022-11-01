package hello.typeconverter.converter;

import hello.typeconverter.coverter.IntegerToStringConverter;
import hello.typeconverter.coverter.IpPortToStringConverter;
import hello.typeconverter.coverter.StringToInteger;
import hello.typeconverter.coverter.StringToIpPortConverter;
import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import javax.print.DocFlavor;

public class ConversionServiceTest {
    @Test
    void conversionService(){
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToInteger());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        Assertions.assertThat(conversionService.convert("10", Integer.class)).isEqualTo(10);
        Assertions.assertThat(conversionService.convert(10, String.class)).isEqualTo("10");
        Assertions.assertThat(conversionService.convert("127.0.0.1:8080", IpPort.class)).isEqualTo(new IpPort("127.0.0.1", 8080));

        Assertions.assertThat(conversionService.convert(new IpPort("127.0.0.1", 8080), String.class)).isEqualTo("127.0.0.1:8080");

    }

}
