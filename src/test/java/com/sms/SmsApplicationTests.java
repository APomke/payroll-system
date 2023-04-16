package com.sms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sms.pojo.Department;
import com.sms.service.DepartmentServiceImpl;
import com.sms.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@SpringBootTest
class SmsApplicationTests {

//    @Autowired
//    @Qualifier("redisTemplate")
//    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;


//    @Test
//    void test2() throws JsonProcessingException {
//        Department department = new Department(1,"测试部",0);
//
//        redisUtil.set("department",department);
//        System.out.println(redisTemplate.opsForValue().get("department"));
//
//    }

}
