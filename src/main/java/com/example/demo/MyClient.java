package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "myclient", url = "http://localhost:8089")
public interface MyClient {
    @RequestMapping("/name")
    public String getName();
}
