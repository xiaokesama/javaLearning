package com.xiaoke.springbootredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @PostMapping("/set")
    public String set(@RequestParam String key, @RequestParam String value) {
        redisService.setValue(key, value);
        return "Value set successfully!";
    }

    @GetMapping("/get")
    public String get(@RequestParam String key) {
        return redisService.getValue(key);
    }

    @PostMapping("/setString")
    public String setString(@RequestParam String key, @RequestParam String value) {
        redisService.setValue(key, value);
        return String.format("key: %s Value: %s set successfully!", key, value);
    }

    @GetMapping("/getString")
    public String getString(@RequestParam String key) {
        return redisService.getValue(key);
    }
}
