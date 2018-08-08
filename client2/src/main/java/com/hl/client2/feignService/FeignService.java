package com.hl.client2.feignService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "localhost",value = "client")
public interface FeignService {
    @RequestMapping(value = "/hello")
    public String hello(@RequestParam(value = "name") String name);
}
