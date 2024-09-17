package com.example.hello.controller;

import com.example.hello.dto.GetRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetController {

    @GetMapping(path = "/hello")
    public String getHello(){
        return "Get Hello";
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET)
    public String hi(){
        return "Hi";
    }

    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName){
        return "Get : "+pathName;
    }

    @GetMapping("/query-param")
    public String queryParams(@RequestParam Map<String, String> queryParam){
        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " : " + entry.getValue());
            sb.append(entry.getKey() + " : " + entry.getValue() + "\n");
        });
        return sb.toString();
    }
    @GetMapping("/query-param3")
    public String queryParam3(GetRequestDto getRequestDto){
        System.out.println(getRequestDto);
        return getRequestDto.toString();
    }
}
