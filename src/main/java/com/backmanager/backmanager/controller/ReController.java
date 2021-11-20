package com.backmanager.backmanager.controller;

import com.backmanager.backmanager.po.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ReController {

    @Autowired
    Customer customer;
    
    
    @RequestMapping("/hello")
    public String ss(){
        System.out.println("ssss");
        return "ssss";
    }
}
