package com.example.company.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公司模块 - Controller
 * @author yuanf
 * @created 2019-08-15
 * */
@RestController
@RequestMapping("company")
public class CompanyController {

    @GetMapping("getCompanyInfo")
    public String getCompanyInfo(){
        return "this is jade.";
    }
}
