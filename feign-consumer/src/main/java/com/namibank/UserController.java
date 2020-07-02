package com.namibank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserFeign userFeign;

    @RequestMapping(value = "getUser",method = RequestMethod.GET)
    public String getUser(){
        User user = userFeign.getUser();
        return user.toString();
    }
}
