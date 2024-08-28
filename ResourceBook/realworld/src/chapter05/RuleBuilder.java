package chapter05;

public class RuleBuilder {

    private Condition condition;
    private ActionV1 action;

    public RuleBuilder when(final Condition condition) {
        this.condition = condition;
        return this;
    }

    public RuleBuilder then(final ActionV1 action) {
        this.action = action;
        return this;
    }

    public Rule createRule() {
        return new DefaultRule(condition, action);
    }

}
