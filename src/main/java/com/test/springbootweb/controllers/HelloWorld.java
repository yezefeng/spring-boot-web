package com.test.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.sql.Array;
import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloWorld {
    @ResponseBody
    @RequestMapping("/hello")
    public String  hello(){
        return "hello";
    }
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }
}
