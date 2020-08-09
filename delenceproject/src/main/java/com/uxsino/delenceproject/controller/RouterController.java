package com.uxsino.delenceproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Yinpengfei
 * @Description 路由Controller
 * @Date 2020/8/8
 **/
@Controller
public class RouterController {
    @RequestMapping({"/","/index"})
    public String index(){
        return "index";
    }
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/views/login";
    }
    @RequestMapping("/test1/{id}")
    public String level(@PathVariable("id") String id){
        return "/test1/"+id;
    }
    @RequestMapping("/test2/{id}")
    public String level1(@PathVariable("id") String id){
        return "/test2/"+id;
    }
    @RequestMapping("/test3/{id}")
    public String level2(@PathVariable("id") String id){
        return "/test3/"+id;
    }
}
