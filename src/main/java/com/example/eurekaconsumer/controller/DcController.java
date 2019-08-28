package com.example.eurekaconsumer.controller;

import com.example.eurekaconsumer.feignClient.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DcController {

//    @Autowired
//    RestTemplate restTemplate;
    @Autowired
    DcClient dcClient;

    @GetMapping("/consumer")
    public String dc(){
//        return restTemplate.getForObject("http://eureka-client/dc", String.class);
        return dcClient.consumer();
    }
}
