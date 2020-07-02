package com.namibank;

import com.namibank.service.HelloServer;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "HELLO-SERVICE")
public interface RefactorHelloService extends HelloServer {


}
