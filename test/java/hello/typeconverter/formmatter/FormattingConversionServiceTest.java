package hello.typeconverter.formmatter;

import hello.typeconverter.coverter.IpPortToStringConverter;
import hello.typeconverter.coverter.StringToIpPortConverter;
import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.format.support.DefaultFormattingConversionService;

public class FormattingConversionServiceTest {

    @Test
    void formattingConversionService(){
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());
        conversionService.addFormatter(new MyNumberFormmatter());

        IpPort ip = conversionService.convert("127.0.0.1:8080", IpPort.class);
        Assertions.assertThat(ip).isEqualTo(new IpPort("127.0.0.1", 8080));

        String convert = conversionService.convert(1000, String.class);
        Assertions.assertThat(convert).isEqualTo("1,000");
        Assertions.assertThat(conversionService.convert("1,000", Long.class)).isEqualTo(1000L);





    }
}
