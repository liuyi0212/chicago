package com.medishare.chicago.dao;

import com.medishare.chicago.utils.RedisSerializeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liuy on 2018/4/13.
 */
@Component
public class RedisClient {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Value("${spring.redis.timeout}")
    String TIMEOUT;

    public void set(String key, String value) throws Exception {
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set(key, value);
    }

    public Long set(String key, List<String> list){
//        for (String str : list){
//
//        }
        return stringRedisTemplate.opsForList().leftPushAll(key,list);
    }


    public String get(String key) throws Exception  {
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        return operations.get(key);
    }

    public void del(String key) throws Exception  {
        if(exists(key))
        stringRedisTemplate.delete(key);
    }

    /**
     * 判断缓存中是否有对应的value
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return stringRedisTemplate.hasKey(key);
    }

}
