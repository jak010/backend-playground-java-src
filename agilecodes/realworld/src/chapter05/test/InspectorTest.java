package chapter05.test;

import chapter05.ConditionalAction;
import chapter05.Facts;
import chapter05.Inspector;
import chapter05.Report;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

import java.util.*;
import java.awt.geom.AffineTransform;


public class InspectorTest {

    // 133page ISP 위반
    @Test
    public void inspectOneConditionEvaluatesTrue() {

        final Facts facts = new Facts();
        facts.setFacts("jobTitle", "CEO");

        final ConditionalAction conditionalAction = new JobTitleCondition();
        final Inspector inspector = new Inspector(conditionalAction);

        final List<Report> reportList = inspector.inspect(facts);

        assertEquals(1, reportList.size());
        assertEquals(true, reportList.get(0).isPositive());
    }

    private static class JobTitleCondition implements ConditionalAction {


        @Override
        public boolean evaluate(Facts facts) {
            return "CEO".equals(facts.getFact("jobTitle"));
        }

        @Override
        public void perform(Facts facts) {
            throw new UnsupportedOperationException();
        }
    }

}
