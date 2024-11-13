package com.xiaoke.aop;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser(String username) {
        System.out.println("add user: " + username);
    }
}
