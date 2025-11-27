package com.godaskids.rules.base.bkp;

import java.util.List;

public class RuleExecutor<T> {
    private final List<Rule<T>> rules;

    public RuleExecutor(List<Rule<T>> rules) {
        this.rules = rules;
    }

    public void execute(T obj, RuleType type) {
        rules.stream()
                .filter(r -> r.getType() == type)
                .forEach(r -> r.validate(obj));
    }
}