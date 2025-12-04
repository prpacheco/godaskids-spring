package com.godaskids.rules.base;

public interface RuleInterface<T> {
    RuleType getType();
    void validate(T obj);
}