package com.urlproject.java;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class UrlShortApplication {

    public static void main(String[] args) {
        SpringApplication.run(UrlShortApplication.class, args);
    }



}
