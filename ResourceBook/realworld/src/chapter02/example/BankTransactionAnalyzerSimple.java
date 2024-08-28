package chapter02.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * 은행 입출금 내역의 총 수입과 총 지출은 얼마인가?
 */
public class BankTransactionAnalyzerSimple {

    private static final String RESOURCES = "/Users/jako/private/git-repo/backend-playground-java-src/agilecodes/realworld/src/chapter02/resource/bank-data-simple.csv";


    /**
     * 개선이 필요한 문제들
     * - 파일이 비어있다면 ?
     * - 데이터에 문제가 있어서 금액을 파싱하지 못한다면 ?
     * - 행의 데이터가 완벽하지 않다면 ?
     * - CSV를 지원하지 않는다면 ?
     * - 데이터 형식이 바뀐다면 ?
     */
    public static void main(final String... args) throws IOException {
        final Path path = Paths.get(RESOURCES);
        final List<String> lines = Files.readAllLines(path);

        double total = 0d;
        for (final String line : lines) {
            final String[] columns = line.split(",");
            final double amount = Double.parseDouble(columns[1]);
            total += amount;
        }

        System.out.println("The total for all transaction is " + total);

    }
}
