//IntelliJ IDEA
//redis
//DataController
//2020/2/12
// Author:御承扬
//E-mail:2923616405@qq.com

package com.pyc.redis.web;

import com.pyc.redis.dao.PersonRepository;
import com.pyc.redis.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/set")
    public void set(){
        Person person = new Person("1", "pyc", 22);
        personRepository.save(person);
        personRepository.stringRedisTemplateDemo();
    }

    @RequestMapping("/getStr")
    public String getStr(){
        return personRepository.getString();
    }

    @RequestMapping("/getPerson")
    public Person getPerson(){
        return personRepository.getPerson();
    }
}
