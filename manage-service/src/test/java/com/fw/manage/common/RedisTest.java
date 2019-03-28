package com.fw.manage.common;

import com.alibaba.fastjson.JSONObject;
import com.fw.manage.entity.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void redisTest() throws Exception{
        Customer customer = new Customer();
        customer.setName("晴天");
        stringRedisTemplate.opsForValue().set("ss", JSONObject.toJSONString(customer),100,TimeUnit.SECONDS);
        System.out.println("#######" + redisTemplate.opsForValue().get("ss"));
        /*redisTemplate.opsForValue().set("hello", "world", 5, TimeUnit.SECONDS);
        Assert.assertEquals("world", redisTemplate.opsForValue().get("hello"));
        System.out.println("1time to live: " + redisTemplate.getExpire("hello"));
        Thread.sleep(1000);
        System.out.println("2time to live: " + redisTemplate.getExpire("hello"));
        Thread.sleep(1000);
        Assert.assertEquals("world", redisTemplate.opsForValue().get("hello"));
        System.out.println("3time to live: " + redisTemplate.getExpire("hello"));
        Thread.sleep(3000);*/
//        Assert.assertEquals("world", redisTemplate.opsForValue().get("hello"));
    }
}
