package com.example.springbootredisexample0.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("set")
    public String setKV(@RequestParam("key") String key, @RequestParam("value") String value) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set(key, value);
        return "success";
    }

    @GetMapping("get")
    public String getKV(@RequestParam("key") String key) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String s = ops.get(key);
        if (s == null)
            s = "no KV";
        return s;
    }

}
