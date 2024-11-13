package com.xiaoke.aop;

public class LoggingAspect implements Aspect {
    @Override
    public void before(String methodName) {
        System.out.println("Before method: " + methodName);
    }

    @Override
    public void after(String methodName) {
        System.out.println("After method: " + methodName);
    }
}
