package com.hl.client2.controller;

import com.hl.client2.feignService.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {
    @Autowired
    FeignService feignService;
    @RequestMapping("/hello")
    public String index(@RequestParam String name){
        return  feignService.hello(name);
    }
}
