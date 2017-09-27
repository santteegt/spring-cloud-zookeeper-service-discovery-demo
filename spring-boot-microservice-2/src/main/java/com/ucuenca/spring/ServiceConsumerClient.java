package com.ucuenca.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by santteegt on 26/09/2017.
 */
@Configuration
@EnableFeignClients
@EnableDiscoveryClient
public class ServiceConsumerClient {

    @Autowired
    private TheClient theClient;

    @FeignClient(name = "GreetingMicroservice")
    interface TheClient {

        @RequestMapping(path = "/", method = RequestMethod.GET)
        @ResponseBody
        String helloWorld();
    }

    public String helloWorld() {
        return theClient.helloWorld();
    }

}
