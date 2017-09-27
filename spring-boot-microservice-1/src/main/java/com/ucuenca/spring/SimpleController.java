package com.ucuenca.spring;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;

import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 * Created by santteegt on 25/09/2017.
 */

@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@RestController
public class SimpleController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        String message = "Hello World from Greeting Microservice located at %s!";
        try {
            String address = InetAddress.getLocalHost().getHostAddress();
            message = String.format(message, address);
        } catch (UnknownHostException e) {
            message = String.format(message, "Unknown Host");
        }

        return message;

    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SimpleController.class, args);
    }
}
