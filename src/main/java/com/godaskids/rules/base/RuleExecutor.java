package com.godaskids.rules.base;

import java.util.List;

public class RuleExecutor<T> {
    private final List<RuleInterface<T>> rules;

    public RuleExecutor(List<RuleInterface<T>> rules) {
        this.rules = rules;
    }

    public void execute(T obj, RuleType type) {
        rules.stream()
                .filter(r -> r.getType() == type)
                .forEach(r -> r.validate(obj));
    }
}