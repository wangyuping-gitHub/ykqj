package com.namibank;

import com.namibank.service.HelloServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    HelloServer helloServer;
    @Autowired
    RefactorHelloService refactorHelloService;

    @RequestMapping(value = "/feign-consumer",method = RequestMethod.GET)
    public String helloConsumer(){

//        return helloServer.hello();
        return "Hello world";
    }

    @RequestMapping(value = "/feign-consumer2",method = RequestMethod.GET)
    public String helloConsumer2(){
        StringBuilder sb = new StringBuilder();
//        sb.append(helloServer.hello()).append("\n");
        sb.append(helloServer.hello("wyp")).append("\n");
        sb.append(helloServer.hello("wyp",27)).append("\n");
        sb.append(helloServer.hello(new User("wyp",27))).append("\n");
        return sb.toString();
    }
    @RequestMapping(value = "/feign-consumer3",method = RequestMethod.GET)
    public String helloConsumer3(){
        StringBuilder sb = new StringBuilder();
//        sb.append(helloServer.hello()).append("\n");
        sb.append(refactorHelloService.hello("wyp")).append("\n");
        sb.append(refactorHelloService.hello("wyp",27)).append("\n");
        sb.append(refactorHelloService.hello(new User("wyp",27))).append("\n");
        return sb.toString();
    }
}
