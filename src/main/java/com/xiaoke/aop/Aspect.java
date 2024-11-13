package com.xiaoke.aop;

public interface Aspect {
    void before(String methodName);
    void after(String methodName);
}