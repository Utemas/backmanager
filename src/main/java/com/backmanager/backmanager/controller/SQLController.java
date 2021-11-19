package com.backmanager.backmanager.controller;

import java.sql.Connection;

import com.backmanager.backmanager.sqlExcute.CreateSql;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SQLController {
    @RequestMapping("/ss")
    public String ee() {
        System.out.println("maind");
        return "ss";
    }
    @RequestMapping("/ww")
    public String name() {
        CreateSql cl = new CreateSql();
        Connection  c1 = cl.connect();
        if(c1 != null){
            return "ll";
        }
        return "ss";
    }
    @RequestMapping("/rr")
    public void man(){

    }
}
