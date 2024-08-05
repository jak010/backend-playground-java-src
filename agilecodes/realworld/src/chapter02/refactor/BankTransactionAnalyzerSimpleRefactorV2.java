package chapter02.refactor;


import chapter02.srp.BankStatementCSVParser;
import chapter02.srp.BankTransaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionAnalyzerSimpleRefactorV2 {

    private static final String RESOURCES = "/Users/jako/private/git-repo/backend-playground-java-src/agilecodes/realworld/src/chapter02/resource/bank-data-simple.csv";


    public static void main(final String... args) throws IOException {

        final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();

        final Path path = Paths.get(RESOURCES);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementCSVParser.parseLineFromCSV(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    public static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("The Total for all transaction is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The Total for transaction in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The Total for transaction in Febuary is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary is " + bankStatementProcessor.totalCalculateForCategory("Salary"));

    }

}
