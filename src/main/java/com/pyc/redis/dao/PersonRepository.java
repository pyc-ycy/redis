//IntelliJ IDEA
//redis
//PersonRepository
//2020/2/12
// Author:御承扬
//E-mail:2923616405@qq.com

package com.pyc.redis.dao;


import com.pyc.redis.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class PersonRepository {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    // 注入基于字符串的简单属性操作方法
    // Injecting simple attribute manipulation methods based on strings
    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valOpsStr;

    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    @Resource(name="redisTemplate")
    ValueOperations<Object, Object> valOps;

    public void stringRedisTemplateDemo(){
        valOpsStr.set("xx","yy");
    }
    public void save(Person person){
        valOps.set(person.getId(),person);
    }
    public String getString(){
        return valOpsStr.get("xx");
    }
    public Person getPerson(){
        return (Person)valOps.get("1");
    }
}
