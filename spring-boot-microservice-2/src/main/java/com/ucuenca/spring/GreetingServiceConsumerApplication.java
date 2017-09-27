package com.ucuenca.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by santteegt on 26/09/2017.
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class GreetingServiceConsumerApplication {

    @Autowired
    private ServiceConsumerClient serviceConsumer;


    @GetMapping("/")
    public String helloWorld() {

        return "Hello Consumer";

    }

    @GetMapping("/get-greeting")
    public String greeting() {

        return serviceConsumer.helloWorld();

    }

    public static void main(String[] args) {
        SpringApplication.run(GreetingServiceConsumerApplication.class, args);
    }

}
