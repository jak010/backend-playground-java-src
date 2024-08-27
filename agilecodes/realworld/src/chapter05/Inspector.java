package chapter05;

import chapter04.ReportImporter;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Inspector {

    private final List<ConditionalAction> conditionalActionList;


    public Inspector(List<ConditionalAction> conditionalActionList) {
        this.conditionalActionList = conditionalActionList;
    }

    public List<Report> inspect(final Facts facts) {
        final List<Report> reportList = new ArrayList<>();
        for (ConditionalAction conditionalAction : conditionalActionList) {
            final boolean conditionalResult = conditionalAction.evaluate(facts);
            reportList.add(new Report(facts, conditionalAction, conditionalResult));
        }
        return reportList;
    }

}
