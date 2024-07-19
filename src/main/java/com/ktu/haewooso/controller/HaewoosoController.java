package com.ktu.haewooso.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HaewoosoController {

    @GetMapping("/hello")   // commit test
    public String hello(){
        return "Hello";
    }
}
