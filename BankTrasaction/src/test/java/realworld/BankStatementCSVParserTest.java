package realworld;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

class BankStatementCSVParserTest {
    private final BankStatementParser bankStatementParser = new BankStatementCSVParser();

    @Test
    void parseForm_메서드는_한_줄이_주어지면_거래내역을_리턴한다() {
        // given
        final String line = "30-01-2017,-50,Tesco";
        final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");

        // when
        final BankTransaction result = bankStatementParser.parseFrom(line);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
