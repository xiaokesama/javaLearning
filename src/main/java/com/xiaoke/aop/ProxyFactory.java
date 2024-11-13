package com.xiaoke.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    public static UserService createProxy(UserService userService, Aspect aspect) {
        return (UserService) Proxy.newProxyInstance(
                userService.getClass().getClassLoader(),
                new Class[]{UserService.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        aspect.before(method.getName()); // 使用传入的切面前置通知
                        Object result = method.invoke(userService, args); // 执行原方法
                        aspect.after(method.getName()); // 使用传入的切面后置通知
                        return result;
                    }
                });
    }
}