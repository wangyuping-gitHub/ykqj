package com.namibank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

@RestController
public class HelloController {
    private final Logger logger = Logger.getLogger(String.valueOf(getClass()));
    @Autowired
    private DiscoveryClient client;
    @Autowired
    private Registration registration; // 服务注册

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index() throws Exception{
        ServiceInstance instance = serviceInstance();
        //让处理线程等待几分钟
        int sleepTime = new Random().nextInt(3000);
        logger.info("sleepTime:" + sleepTime);
        Thread.sleep(sleepTime);

        if(instance!=null){
            logger.info("/hello,host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        }
        return "Hello World";
    }
    public ServiceInstance serviceInstance() {
        List<ServiceInstance> list = client.getInstances(registration.getServiceId());
        if (list != null && list.size() > 0) {
            for(ServiceInstance itm : list){
                if(itm!=null)
                    return itm;
            }
        }
        return null;
    }

    @RequestMapping(value = "hello1",method = RequestMethod.GET)
    public String hello(@RequestParam String name){

        return "Hello " + name;
    }

    @RequestMapping(value = "hello2",method = RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age){

        return new User(name,age);
    }

    @RequestMapping(value = "hello3",method = RequestMethod.POST)
    public String hello(@RequestBody User user){

        return "Hello " + user.getName() + "," + user.getAge();
    }

    @RequestMapping(value = "getUser",method = RequestMethod.GET)
    public User getUser(){
        User user = new User();
        user.setName("liuchao");
        return user;
    }

}
