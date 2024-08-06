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

public class BankTransactionAnalyzerRefactor {

    private static final String RESOURCES = "/Users/jako/private/git-repo/backend-playground-java-src/agilecodes/realworld/src/chapter02/resource/bank-data-simple.csv";


    public static void main(final String... args) throws IOException {

        final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();

        final Path path = Paths.get(RESOURCES);
        final List<String> lines = Files.readAllLines(path);

//        double total = 0d;
//        for (final String line : lines) {
//            final String[] columns = line.split(",");
//            final double amount = Double.parseDouble(columns[1]);
//            total += amount;
//        }
//        System.out.println("The total for all transaction is " + total);

        final List<BankTransaction> bankTransactions = bankStatementCSVParser.parseLineFromCSV(lines);

        System.out.println("The total for all transaction is " + calculateTotalAmount(bankTransactions));
        System.out.println("Transaction is January" + selectInMonth(bankTransactions, Month.JANUARY));

    }

    private static List<BankTransaction> selectInMonth(List<BankTransaction> bankTransactions, final Month month) {
        final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();

        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                bankTransactionsInMonth.add(bankTransaction);
            }
        }
        return bankTransactionsInMonth;
    }

    /**
     * 계산 작업을 하는 calculateTotalAmount 정적 메서드로 선언되어있다.
     *  이 클래스에 정의된 계산 관련 작업은 파싱이나 결과 전송과는 직접적인 관련이 없으므로 응집도가 떨어지는 클래스의 사례다.
     *  대신, 계산 연산을 BankAnalzyerProcessor라는 별도의 클래스로 추출한다.
     *      또한 모든 연산에서 메서드 인수인 입출급 내역 목록을 공유하므로 이를 클래스 필드로 만든다.
     * */
    private static double calculateTotalAmount(List<BankTransaction> bankTransactions) {


        double total = 0d;
        for (final BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

}
