package com.example.httpresponse.controller;

import com.example.httpresponse.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/main")
    public String main(){
        return "main.html";
    }


    // how to return json on page controller?
    //ResponseEntity
    @ResponseBody
    @GetMapping("/user")
    public User user(){
        var user = new User();
        user.setName("test");
        user.setAddress("add");
        return user;
    }
}
