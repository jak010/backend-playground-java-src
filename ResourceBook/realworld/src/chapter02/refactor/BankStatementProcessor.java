package chapter02.refactor;

import chapter02.srp.BankTransaction;

import java.time.Month;
import java.util.List;

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactionList;


    public BankStatementProcessor(List<BankTransaction> bankTransactionList) {
        this.bankTransactionList = bankTransactionList;
    }

    public double calculateTotalAmount() {
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactionList) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public double calculateTotalInMonth(final Month month) {
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactionList) {
            if (bankTransaction.getDate().getMonth() == month) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double totalCalculateForCategory(final String category) {
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactionList) {
            if (bankTransaction.getDescription().equals(category)) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }
}
