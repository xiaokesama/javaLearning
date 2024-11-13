package com.xiaoke.annotation;

import org.junit.Test;

public class MyService {

    /**
     * 加上自定义注解
     */
    @MyCustomAnnotation("This is a custom annotation")
    @Test
    public void myAnnotatedMethod() {
        System.out.println("Executing myAnnotatedMethod...");
    }

    /**
     * 没有自定义注解
     */
    public void myNormalMethod() {
        System.out.println("Executing myNormalMethod...");
    }
}