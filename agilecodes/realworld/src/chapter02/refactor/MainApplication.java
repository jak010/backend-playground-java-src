package chapter02.refactor;

import java.io.IOException;

public class MainApplication {

    public static void main(String... args) throws IOException {

        final BankTransactionAnalyzerRefactorV3 bankTransactionAnalyzerSimpleRefactorV3 = new BankTransactionAnalyzerRefactorV3();
        final BankStatementParser bankStatementParser = new BankStatementCSVParser();

        bankTransactionAnalyzerSimpleRefactorV3.analyze("Empty", bankStatementParser);
    }
}
