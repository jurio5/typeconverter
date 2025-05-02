package hello.typeconverter.formatter;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
class MyNumberFormatterTest {

    MyNumberFormatter formatter = new MyNumberFormatter();

    @Test
    void parse() throws ParseException {
        // given
        Number parse = formatter.parse("1,000", Locale.KOREA);

        // when & then
        assertThat(parse).isEqualTo(1000L); // Long 타입 주의 (Number 는 추상클래스니까 구체적으로 작성)
    }

    @Test
    void print() {
        // given
        String result = formatter.print(1000, Locale.KOREA);

        // when & then
        assertThat(result).isEqualTo("1,000");
    }
}