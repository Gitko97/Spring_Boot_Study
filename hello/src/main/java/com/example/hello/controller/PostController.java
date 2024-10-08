package com.example.hello.controller;

import com.example.hello.dto.PostRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @PostMapping
    public void post(@RequestBody Map<String, Object> requestData){
        requestData.forEach((key, value) -> System.out.println(key + " : " + value));
    }

    @PostMapping("/dto")
    public void postDto(@RequestBody PostRequestDto requestData){
        System.out.println(requestData);
    }
}
