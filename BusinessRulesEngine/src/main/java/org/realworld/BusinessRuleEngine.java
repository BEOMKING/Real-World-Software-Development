package org.realworld;

import java.util.ArrayList;
import java.util.List;

public class BusinessRuleEngine {
    private final List<Action> actions = new ArrayList<>();

    public void addAction(final Action action) {
        actions.add(action);
    }

    public int count() {
        return this.actions.size();
    }

    public void run() {
        this.actions.forEach(Action::execute);
    }
}
