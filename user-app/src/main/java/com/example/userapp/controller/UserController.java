package com.example.userapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 用户 - Controller
 * @created 2019-08-15
 * @author yuanf
 * */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/getUserInfo")
    public String getUserInfo(){
        return "hello,yuan feng.";
    }

    /**
     * 第一种方式
     * user模块调用company数据
     * */
    @GetMapping("getCompanyInfoFromUser")
    public String getCompanyInfoFromUser1(){
        // 第一种方式
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://localhost:8082/company/getCompanyInfo",String.class);
        return response;
    }

    /**
     * 第二种方式
     * user模块调用company数据
     * */
    @GetMapping("getCompanyInfoFromUser")
    public String getCompanyInfoFromUser2(){
        // 第一种方式
        ServiceInstance serviceInstance = loadBalancerClient.choose("COMPANY-APP");
        String url = String.format("http://%s:%s",
                serviceInstance.getHost(),serviceInstance.getPort() + "/company/getCompanyInfo");
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url,String.class);
        return response;
    }
}
