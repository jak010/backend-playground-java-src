package chapter05;

import java.util.ArrayList;
import java.util.List;

// 120 page
public class BusinessRuleEngineV2 {

    private final List<Action> actionsList;

    public BusinessRuleEngineV2() {
        this.actionsList = new ArrayList<>();
    }

    public void addAction(final Action action) {
        this.actionsList.add(action);
    }

    public int count() {
        return this.actionsList.size();
    }

    public void run() {
        this.actionsList.forEach(Action::execute);
    }

}
