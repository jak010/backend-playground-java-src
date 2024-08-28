package chapter05.test;

import chapter05.BusinessRuleEngine;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BusinessRuleEngineTest {

    @Test
    public void shouldHaveNoRulesInitially() {
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();

        assertEquals(0, businessRuleEngine.count());
    }

    @Test
    public void shouldAddTwoActions() {
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();

//        businessRuleEngine.addAction(() -> {
//        });
//        businessRuleEngine.addAction(() -> {
//        });

        assertEquals(2, businessRuleEngine.count());

    }

}
