package com.namibank;

import com.namibank.service.HelloServer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefactorHelloService implements HelloServer {

    public String hello(@RequestParam("name") String name){

        return "Hello " + name;
    }

    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age){
        return new User(name, age);
    }

    public String hello(@RequestBody User user){

        return "Hello " + user.getName()+", "+user.getAge();
    }
}
