package chapter05;

import java.util.ArrayList;
import java.util.List;

public class BusinessRuleEngineV3 {

    private final List<ActionV2> actionsList;
    private final Facts facts;

    public BusinessRuleEngineV3(final Facts facts) {
        this.facts = facts;
        this.actionsList = new ArrayList<>();

    }

    public void addAction(final ActionV2 action) {
        this.actionsList.add(action);
    }

    public int count() {
        return this.actionsList.size();
    }

    public void run() {
        this.actionsList.forEach(actionV2 -> actionV2.perform(facts));
    }

}
