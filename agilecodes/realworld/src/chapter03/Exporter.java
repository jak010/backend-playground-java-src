package chapter03;

import org.hamcrest.core.SubstringMatcher;

public interface Exporter {

    String export(SummaryStatistics summaryStatistics);

}
