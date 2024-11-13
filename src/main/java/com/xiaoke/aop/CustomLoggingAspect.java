package com.xiaoke.aop;

public class CustomLoggingAspect implements Aspect {
    @Override
    public void before(String methodName) {
        System.out.println("Custom Before method: " + methodName);
    }

    @Override
    public void after(String methodName) {
        System.out.println("Custom After method: " + methodName);
    }
}