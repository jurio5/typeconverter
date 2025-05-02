package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConverterTest {

    @Test
    void stringToInteger() {
        // given
        StringToIntegerConverter converter = new StringToIntegerConverter();

        // when
        Integer result = converter.convert("10");

        // then
        assertThat(result).isEqualTo(10);
    }

    @Test
    void integerToString() {
        // given
        IntegerToStringConverter converter = new IntegerToStringConverter();

        // when
        String result = converter.convert(10);

        // then

        assertThat(result).isEqualTo("10");
    }

    @Test
    void stringToIpPort() {
        // given
        IpPortToStringConverter converter = new IpPortToStringConverter();

        // when
        IpPort source = new IpPort("127.0.0.1", 8080);
        String convert = converter.convert(source);

        // then
        assertThat(convert).isEqualTo("127.0.0.1:8080");
    }

    @Test
    void ipPortToString() {
        // given
        StringToIpPortConverter converter = new StringToIpPortConverter();

        // when
        String source = "127.0.0.1:8080";
        IpPort result = converter.convert(source);

        // then
        assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080));
    }
}
