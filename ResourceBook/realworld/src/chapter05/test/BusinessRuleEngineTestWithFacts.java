package chapter05.test;

import chapter05.*;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

// 124 page
public class BusinessRuleEngineTestWithFacts {


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

    @Test
    public void shouldExecuteOneAction() {
        final BusinessRuleEngineV2 businessRuleEngineV2 = new BusinessRuleEngineV2();
        final Action mockAction = mock(Action.class);

        businessRuleEngineV2.addAction(mockAction);
        businessRuleEngineV2.run();

        verify(mockAction).execute(); // 책에서는 perform이라고 되어있는데 Action의 execute가 실행되었는지 체크하는 부분이기에 execute가 맞음

    }

    @Test
    public void shouldPerformAnACtionWithFacts() {
        final ActionV2 mockAction = mock(ActionV2.class);
        final Facts mockFacts = mock(Facts.class);
        final BusinessRuleEngineV3 busniessRuleEngineV3 = new BusinessRuleEngineV3(mockFacts);

        busniessRuleEngineV3.addAction(mockAction);
        busniessRuleEngineV3.addAction(facts -> {
            final String jobTitle = facts.getFact("jobTitle");
            if ("CEO".equals(jobTitle)) {
                final String name = facts.getFact("name");
//                Mailer.sendEmail("")
            }
        });
        busniessRuleEngineV3.run();

        verify(mockAction).perform(mockFacts);


    }

}
