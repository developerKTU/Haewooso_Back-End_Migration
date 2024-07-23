package com.ktu.haewooso.controller;

import org.springframework.web.bind.annotation.*;

@RestController("/")
public class HomeController {
    @GetMapping("api/hello")
    public String hello(){
        return "Hello";
    }
}
