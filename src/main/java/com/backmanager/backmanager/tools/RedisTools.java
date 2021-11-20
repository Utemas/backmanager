package com.backmanager.backmanager.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
@SuppressWarnings("all")
public class RedisTools {
    @Autowired
    private RedisTemplate<String,String> rts;

    @Autowired
    private RedisTemplate<Object,Object> rto;

    public void set(String key,String value) {
          rts.opsForValue().set(key, value);  
    }

    public void set(Object key,Object value) {
        rto.opsForValue().set(key, value);  
    }
    public String get(String key) {
        return String.valueOf(rts.opsForValue().get(key));  
    }
    public Object get(Object key,Object value) {
        return rto.opsForValue().get(key);  
    }
}
