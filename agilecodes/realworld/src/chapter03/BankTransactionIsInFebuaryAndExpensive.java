package chapter03;

import java.time.Month;

public class BankTransactionIsInFebuaryAndExpensive implements BankTransactionFilter {

    /**
     * Usage
     *   final List<BankTransaction> transactions = new bankStatementProcessor.findTransactions(new BankTransactionIsInFebuaryAndExpensive())
     * */
    @Override
    public boolean test(final BankTransaction bankTransaction) {
        return bankTransaction.getDate().getMonth() == Month.FEBRUARY && bankTransaction.getAmount() >= 1_000;
    }
}
