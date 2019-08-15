package com.example.userapp.company.client;

/**
 * 公司模块 Feign 客户端调用
 * */

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "company")
public interface CompanyFeignClient {


    /**
     * feign 调用company模块接口
     * */
    @GetMapping("getCompanyInfo")
    String getCompanyInfo();
}
