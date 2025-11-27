package com.godaskids.rules.base;

import com.godaskids.rules.base.bkp.RuleType;

public interface RuleExecutor <T> {
    void execute(T obj, RuleType type);
}