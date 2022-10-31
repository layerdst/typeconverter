package hello.typeconverter.coverter;

import hello.typeconverter.type.IpPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class StringToIpPortConverter implements Converter<String, IpPort> {
    @Override
    public IpPort convert(String source) {
        log.info("covert source = {}", source);
        String[] sp = source.split(":");
        String ip = sp[0];
        int port = Integer.parseInt(sp[1]);
        return new IpPort(ip, port);
    }
}
