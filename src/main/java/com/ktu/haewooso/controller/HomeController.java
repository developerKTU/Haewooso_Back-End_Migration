package com.ktu.haewooso.controller;

import com.ktu.haewooso.dto.MemberDto;
import com.ktu.haewooso.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/")
public class HomeController {
    @GetMapping("api/hello")
    public String hello(){
        return "Hello";
    }
}
