package com.xiaoke.aop;

public class Test {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl(); // 假设您有 UserServiceImpl 实现
        Aspect loggingAspect = new LoggingAspect(); // 使用默认切面
        UserService proxy = ProxyFactory.createProxy(userService, loggingAspect);
        proxy.addUser("John Doe");

        // 使用自定义切面
        Aspect customLoggingAspect = new CustomLoggingAspect();
        UserService customProxy = ProxyFactory.createProxy(userService, customLoggingAspect);

        customProxy.addUser("Jane Doe");
    }
}