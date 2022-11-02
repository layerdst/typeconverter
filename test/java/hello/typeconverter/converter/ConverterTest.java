package hello.typeconverter.converter;


import hello.typeconverter.coverter.IntegerToStringConverter;
import hello.typeconverter.coverter.IpPortToStringConverter;
import hello.typeconverter.coverter.StringToInteger;
import hello.typeconverter.coverter.StringToIpPortConverter;
import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConverterTest {

    @Test
    void stringToInteger(){
        StringToInteger converter = new StringToInteger();
        Integer result = converter.convert("19");
        Assertions.assertThat(result).isEqualTo(19);
    }

    @Test
    void integerTostring(){
        IntegerToStringConverter converter = new IntegerToStringConverter();
        String rs = converter.convert(10);
        Assertions.assertThat(rs).isEqualTo("10");
    }

    @Test
    void ipPortToString(){
        IpPortToStringConverter converter = new IpPortToStringConverter();
        IpPort s = new IpPort("127.0.0.1", 5000);
        String result = converter.convert(s);
        Assertions.assertThat(result).isEqualTo("127.0.0.1:5000");
    }

    @Test
    void StringToIp(){
        StringToIpPortConverter converter = new StringToIpPortConverter();
        String source = "127.0.0.1:8000";
        IpPort result = converter.convert(source);
        System.out.println(result.getIp() + result.getPort());
        Assertions.assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8000));
    }



}
