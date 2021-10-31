package com.backmanager.backmanager.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.backmanager.backmanager.param.PathParam;
import com.backmanager.backmanager.tools.ExcutePython;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
@RequestMapping("/search")
public class SearchController {

    PathParam pathParam = new PathParam();
    @RequestMapping("/net")
    public String searchFromNet(@RequestParam(value = "search" )String search){
        //ExcutePython.topythonByParam("searchInternet", "https://www.baidu.com/s?ie=UTF-8&wd=ss");
        ExcutePython.topythonByParam("searchInternet","hhhh");
        return "大傻逼";
    }
}
