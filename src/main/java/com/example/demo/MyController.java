package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {


    @Autowired
    MyClient myClient;

    @GetMapping("/hello")
    String getHello() {

        return myClient.getName();
    }
}
