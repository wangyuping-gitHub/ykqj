package com.namibank;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "HELLO-SERVICE")
public interface UserFeign {

    @RequestMapping(value = "getUser2",method = RequestMethod.GET)
    User getUser();
}
