package chapter05.test;

import chapter05.Action;
import chapter05.BusinessRuleEngine;
import chapter05.BusinessRuleEngineV2;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BusinessRuleEngineTestWithMockito {


    @Test
    public void shouldHaveNoRulesInitially() {
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();

        assertEquals(0, businessRuleEngine.count());
    }

    @Test
    public void shouldAddTwoActions() {
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();

        businessRuleEngine.addAction(() -> {
        });
        businessRuleEngine.addAction(() -> {
        });

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

}
