package com.example.iot_web_demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class DeviceController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello, World!";
    }
    @GetMapping("/device")
    public String sayDevice(){
        return "online device : 3";
    }
}
