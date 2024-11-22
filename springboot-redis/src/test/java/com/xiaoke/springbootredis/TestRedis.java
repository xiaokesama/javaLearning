package com.xiaoke.springbootredis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class TestRedis {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void testSet() {
        redisTemplate.opsForValue().set("session:userId:123", "logged_in");
    }

}
