package com.example.springbootredisexample1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

@SpringBootTest
class SpringbootRedisExample1ApplicationTests {

    @Autowired
    private JedisPool jedisPool;

    @Test
    void contextLoads() {
        Jedis jedis = jedisPool.getResource();
        jedis.flushAll();
        Set<String> keys = jedis.keys("*");
        keys.forEach(key -> {
            System.out.println(key + ", " + jedis.get(key));
        });
    }

    @Test
    public void set() {
        Jedis jedis = jedisPool.getResource();
        jedis.set("hello", "world");
    }

    @Test
    public void get() {
        Jedis jedis = jedisPool.getResource();
        System.out.println(jedis.get("hello"));
    }
}
