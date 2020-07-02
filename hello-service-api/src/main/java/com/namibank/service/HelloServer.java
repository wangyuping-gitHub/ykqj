package com.namibank.service;

import com.namibank.User;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/refactor")
public interface HelloServer {

    /*@RequestMapping("/hello")
    String hello();*/

    @RequestMapping(value = "hello4",method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello5",method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello6",method = RequestMethod.POST)
    String hello(@RequestBody User user);
}
