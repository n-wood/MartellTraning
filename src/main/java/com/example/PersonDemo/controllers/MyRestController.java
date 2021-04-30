package com.example.PersonDemo.controllers;

import com.example.PersonDemo.models.Person;
import com.example.PersonDemo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/rest")
public class MyRestController {

    @Autowired
    PersonService service;

    public MyRestController() {
        System.out.println(">>REST Controller started");
    }

    @GetMapping(value = "/names/{nameOfPerson}")
    public Person getPerson(
            @PathVariable("nameOfPerson") String name,
            @RequestParam(value = "nickName", required = false) String nick,
            @RequestHeader(value = "person-age", required = false) String age
    ) {

        Person model = service.getPerson(name, nick, age);
        return model;
    }
}
