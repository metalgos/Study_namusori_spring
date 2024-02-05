package io.namoosori.hello.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String come(){
        return "Hello Spring Boot";
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello Spring Boot";
    }
}
