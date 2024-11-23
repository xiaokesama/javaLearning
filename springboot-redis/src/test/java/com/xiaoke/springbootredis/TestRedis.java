package com.xiaoke.springbootredis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@SpringBootTest
public class TestRedis {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void testSetString() {
        redisTemplate.opsForValue().set("session:userId:123", "logged_in");
    }

    @Test
    public void testGetString() {
        String value = redisTemplate.opsForValue().get("session:userId:123");
        System.out.println(value);
    }

    @Test
    public void testPutHash(){
        redisTemplate.opsForHash().put("user:123", "name", "John");
        redisTemplate.opsForHash().put("user:123", "age", "30");
        redisTemplate.opsForHash().put("user:123", "email", "john@example.com");
    }

    @Test
    public void testGetHash(){
        String name = (String) redisTemplate.opsForHash().get("user:123", "name");
        String age = (String) redisTemplate.opsForHash().get("user:123", "age");
        String email = (String) redisTemplate.opsForHash().get("user:123", "email");
        System.out.println(name + " " + age + " " + email);
    }

    @Test
    public void testPushToList(){
        redisTemplate.opsForList().rightPush("taskQueue", "task1");
        redisTemplate.opsForList().rightPush("taskQueue", "task2");
        redisTemplate.opsForList().leftPush("taskQueue", "task3");
    }

    @Test
    public void testGetList(){
        System.out.println(redisTemplate.opsForList().range("taskQueue", 0, -1));
        System.out.println(redisTemplate.opsForList().size("taskQueue"));
        System.out.println(redisTemplate.opsForList().leftPop("taskQueue"));
    }

    @Test
    public void testSetSet(){
        redisTemplate.opsForSet().add("user:123:friends", "user:456");
        redisTemplate.opsForSet().add("user:123:friends", "user:789");
        redisTemplate.opsForSet().add("user:456:friends", "user:123");
    }

    @Test
    public void testGetSet(){
        System.out.println(redisTemplate.opsForSet().members("user:123:friends"));
        System.out.println(redisTemplate.opsForSet().size("user:123:friends"));
    }

    @Test
    public void testSetSortedSet(){
        redisTemplate.opsForZSet().add("user:123:scores", "score1", 10);
        redisTemplate.opsForZSet().add("user:123:scores", "score2", 20);
        redisTemplate.opsForZSet().add("user:123:scores", "score3", 30);
    }

    @Test
    public void testGetSortedSet(){
        System.out.println(redisTemplate.opsForZSet().range("user:123:scores", 0, -1));
        System.out.println(redisTemplate.opsForZSet().size("user:123:scores"));
        System.out.println(redisTemplate.opsForZSet().score("user:123:scores", "score2"));
    }

    @Test
    public void testSetBitmap(){
        long userId = 9527;
        redisTemplate.opsForValue().setBit("active:2024-11-01", userId, true);
        redisTemplate.opsForValue().setBit("active:2024-11-02", userId, true);
        redisTemplate.opsForValue().setBit("active:2024-11-03", userId, false);
    }

    @Test
    public void testGetBitmap() {
        long userId = 9527;
        System.out.println(redisTemplate.opsForValue().getBit("active:2024-11-01", userId));
        System.out.println(redisTemplate.opsForValue().getBit("active:2024-11-02", userId));
        System.out.println(redisTemplate.opsForValue().getBit("active:2024-11-03", userId));
    }

    @Test
    public void testSetHyperLogLog() {
        redisTemplate.opsForHyperLogLog().add("user:123:visited", "page1");
        redisTemplate.opsForHyperLogLog().add("user:123:visited", "page2");
        redisTemplate.opsForHyperLogLog().add("user:123:visited", "page3");
    }

    @Test
    public void testGetHyperLogLog() {
        System.out.println(redisTemplate.opsForHyperLogLog().size("user:123:visited"));
    }

    @Test
    public void testSetGeo() {
        redisTemplate.opsForGeo().add("restaurants",
                new RedisGeoCommands.GeoLocation<>("restaurant1", new Point(13.361389, 38.115556)));
        redisTemplate.opsForGeo().add("restaurants",
                new RedisGeoCommands.GeoLocation<>("restaurant2", new Point(15.087269, 37.502669)));
        redisTemplate.opsForGeo().add("restaurants",
                new RedisGeoCommands.GeoLocation<>("restaurant3", new Point(15.087269, 37.502669)));
    }

    @Test
    public void testGetGeo() {
        // 获取"restaurants"集合中指定地点的地理位置
        List<Point> points = redisTemplate.opsForGeo().position("restaurants", "restaurant1", "restaurant2", "restaurant3");
        if (points != null) {
            for (Point point : points) {
                System.out.println("Longitude: " + point.getX() + ", Latitude: " + point.getY());
            }
        } else {
            System.out.println("No points found.");
        }

        // 获取"restaurants"集合中指定地点之间的距离
        Distance distance = redisTemplate.opsForGeo().distance("restaurants", "restaurant1", "restaurant2");
        if (distance != null) {
            System.out.println("Distance between restaurant1 and restaurant2: " + distance.getValue() + " " + distance.getMetric());
        } else {
            System.out.println("Distance could not be calculated.");
        }
    }



}
