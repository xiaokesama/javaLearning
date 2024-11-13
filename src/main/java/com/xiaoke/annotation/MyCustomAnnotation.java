package com.xiaoke.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 */
// 定义注解
@Retention(RetentionPolicy.RUNTIME) // 注解在运行时可用
@Target(ElementType.METHOD) // 注解可用于方法
public @interface MyCustomAnnotation {
    String value(); // 注解的属性
}
