package com.godaskids.rules.base;

public interface RuleExecutorInterface<T> {
    void execute(T obj, RuleType type);
}