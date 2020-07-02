package com.namibank;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 *
 */
@EnableZuulProxy
@SpringBootApplication
public class ApiGatewayApp {

    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }
    public static void main( String[] args ) {
//        System.out.println( "Hello World!" );
        new SpringApplicationBuilder(ApiGatewayApp.class).web(WebApplicationType.SERVLET).run(args);
    }
}
