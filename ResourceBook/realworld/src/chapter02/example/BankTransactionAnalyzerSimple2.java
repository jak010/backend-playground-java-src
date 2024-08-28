package chapter02.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 특정 달엔 몇 건의 입출금 내역이 발생했는가?
 */
public class BankTransactionAnalyzerSimple2 {


    private static final String RESOURCES = "/Users/jako/private/git-repo/backend-playground-java-src/agilecodes/realworld/src/chapter02/resource/bank-data-simple.csv";


    public static void main(final String... args) throws IOException {


        final Path path = Paths.get(RESOURCES);
        final List<String> lines = Files.readAllLines(path);

        double total = 0d;
        final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for (final String line : lines) {
            final String[] columns = line.split(",");

            final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
            if (date.getMonth() == Month.JANUARY) {
                double amount = Double.parseDouble(columns[1]);
                total += amount;
            }
        }

        System.out.println("The total for all transaction in January " + total);

    }

}
