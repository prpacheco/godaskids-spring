package com.godaskids.rules.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenericRuleExecutor <T> implements RuleExecutorInterface<T> {

    private final List<RuleInterface<T>> rules;

    @Autowired
    public GenericRuleExecutor(List<RuleInterface<T>> rules) {
        this.rules = rules;
    }

    @Override
    public void execute(T obj, RuleType type) {
        rules.stream()
                .filter(rule -> rule.getType() == type)
                .forEach(rule -> rule.validate(obj));
    }
}
