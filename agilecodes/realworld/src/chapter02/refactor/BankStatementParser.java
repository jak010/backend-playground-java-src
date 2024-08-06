package chapter02.refactor;

import chapter02.srp.BankTransaction;

import java.util.List;

/**
 * 결합도를 낮추기 위한 인터페이스(39page)
 * */
public interface BankStatementParser {

    BankTransaction parseFrom(String line);

    List<BankTransaction> parseLineFrom(List<String> lines);

}
