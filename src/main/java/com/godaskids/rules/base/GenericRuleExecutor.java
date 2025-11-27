package com.godaskids.rules.base;

import com.godaskids.rules.base.bkp.Rule;
import com.godaskids.rules.base.bkp.RuleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenericRuleExecutor <T> implements RuleExecutor<T> {

    private final List<Rule<T>> rules;

    @Autowired
    public GenericRuleExecutor(List<Rule<T>> rules) {
        this.rules = rules;
    }

    @Override
    public void execute(T obj, RuleType type) {
        rules.stream()
                .filter(rule -> rule.getType() == type)
                .forEach(rule -> rule.validate(obj));
    }
}
