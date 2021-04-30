package com.example.PersonDemo.controllers;

import com.example.PersonDemo.models.Person;
import com.example.PersonDemo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value= "/legacy")
public class MyLegacyController {

    @Autowired
    PersonService service;

    public MyLegacyController() {
        System.out.println(">>LEGACY Controller started");
    }

    @RequestMapping (value = "/names/{nameOfPerson}", method = RequestMethod.GET)
    @ResponseBody
    public Person getPerson(@PathVariable("nameOfPerson") String name,
                            @RequestParam(value = "nickName", required = false) String nick,
                            @RequestHeader(value = "person-age", required = false) String age)
    {
        Person model = service.getPerson(name, nick, age);
        return model;
    }
}
