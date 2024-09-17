package com.example.filterandinterceptor.controller;

import com.example.filterandinterceptor.annotation.AuthUser;
import com.example.filterandinterceptor.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AuthUser
@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/post")
    public User post(@RequestBody User user){
        log.info(user.toString());
        return user;
    }

    @DeleteMapping("/delete")
    public ResponseEntity post(){
        return ResponseEntity.ok().build();
    }
}
