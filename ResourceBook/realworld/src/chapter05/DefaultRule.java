package chapter05;

public class DefaultRule implements Rule {

    private final Condition condition;
    private final ActionV1 action;

    public DefaultRule(Condition condition, ActionV1 action) {
        this.condition = condition;
        this.action = action;
    }

    @Override
    public void perform(Facts facts) {
        if(condition.evaluate(facts)) {
            action.execute(facts);
        }
    }
}
