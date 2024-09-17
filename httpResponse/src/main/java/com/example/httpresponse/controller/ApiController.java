package com.example.httpresponse.controller;

import com.example.httpresponse.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    // Text
    @GetMapping("/text")
    public String text(@RequestParam String account){
        return account;
    }

    // Json
    // request -> object mapper -> object -> method -> object -> object mapper -> json -> response
    @PostMapping("/json")
    public User json(@RequestBody User user){
        return user; // 200 ok
    }
    
    // 응답 설정
    // put은 create 될 때도 있음
    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user){
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
