package com.godaskids.rules.base.bkp;

public interface Rule <T> {
    RuleType getType();
    void validate(T obj);
}