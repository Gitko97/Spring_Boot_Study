package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("------------------");

        // Object mapper?
        // Text Json -> object & object -> json

        var objectMapper = new ObjectMapper();

        // object -> text
        // object mapper 는 text로 바꿀때 get 메소드를 활용
        var user = new User("steve", 10, "0104585145");

        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        // text -> object
        // object mapper 는 object로 바꿀때 default 생성자를 필요로 한다.
        var objectUser = objectMapper.readValue(text, User.class);
        System.out.println(objectUser);
    }

}
