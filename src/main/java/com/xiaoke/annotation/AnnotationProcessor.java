package com.xiaoke.annotation;

import java.lang.reflect.Method;

/**
 * 注解处理器
 */
public class AnnotationProcessor {

    public static void main(String[] args) {
        MyService myService = new MyService();

        // 获取 MyService 类的所有方法
        Method[] methods = MyService.class.getDeclaredMethods();

        for (Method method : methods) {
            // 检查方法是否有 MyCustomAnnotation 注解
            if (method.isAnnotationPresent(MyCustomAnnotation.class)) {
                // 获取注解
                MyCustomAnnotation annotation = method.getAnnotation(MyCustomAnnotation.class);
                // 输出注解的值和方法名
                System.out.println("Method: " + method.getName() + ", Annotation Value: " + annotation.value());
            }
        }

        // 调用被注解的方法
        myService.myAnnotatedMethod();
    }
}
