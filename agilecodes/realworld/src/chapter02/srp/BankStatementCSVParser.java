package chapter02.srp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * parsing 로직을 추출해 한 클래스로 만들기
 */
public class BankStatementCSVParser {

    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private BankTransaction parseFormCSV(final String line) {
        final String[] columns = line.split(",");

        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];

        return new BankTransaction(date, amount, description);
    }

    public List<BankTransaction> parseLineFromCSV(final List<String> lines) {
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for (final String line : lines) {
            bankTransactions.add(parseFormCSV(line));
        }
        return bankTransactions;
    }


}
