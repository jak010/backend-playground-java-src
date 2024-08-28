package chapter03;

import chapter03.BankTransaction;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;


public class BankStatementProcessorV2 {

    private final List<BankTransaction> bankTransactionList;


    public BankStatementProcessorV2(List<BankTransaction> bankTransactionList) {
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

    /**
     * 특정 금액 이상의 은행 거래 내역 찾기 (51page)
     */
    public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount) {
        final List<BankTransaction> result = new ArrayList<>();

        for (final BankTransaction bankTransaction : bankTransactionList) {
            if (bankTransaction.getAmount() >= amount) {
                result.add(bankTransaction);
            }
        }
        return result;
    }

    /**
     * 특정 금액 이상의 은행 거래 내역 찾기 (51page)
     */
    public List<BankTransaction> findTransactionsInMonth(final Month month) {
        final List<BankTransaction> result = new ArrayList<>();

        for (final BankTransaction bankTransaction : bankTransactionList) {
            if (bankTransaction.getDate().getMonth() == month) {
                result.add(bankTransaction);
            }
        }
        return result;
    }

    /**
     * OCP를 적용한 후 유연해진 findTransactions() 메서드
     * - 이 메서드를 적용하기 전의 예제는 findTransactionsGreaterThanEqual와 findTransactionsInMonth의 코드를 하나의 메서드에서 사용했다.
     */
    public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter) {
        final List<BankTransaction> result = new ArrayList<>();

        for (final BankTransaction bankTransaction : bankTransactionList) {
            if (bankTransactionFilter.test(bankTransaction)) {
                result.add(bankTransaction);
            }
        }
        return result;
    }

}
