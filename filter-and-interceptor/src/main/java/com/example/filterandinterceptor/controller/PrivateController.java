package com.example.filterandinterceptor.controller;

import com.example.filterandinterceptor.annotation.AuthUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/private")
@AuthUser
public class PrivateController {

    @GetMapping
    public String hello(){
        return "private hello";
    }

}
