package com.example.PersonDemo.controllers;

import com.example.PersonDemo.models.Person;
import com.example.PersonDemo.services.PersonServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;

class MyRestControllerTest {

    @Test
    public void getPerson()
    {
        MyRestController c = new MyRestController();
        ReflectionTestUtils.setField(c, "service", new PersonServiceImpl());
        Person result = c.getPerson("Nathan","Nath","44");
        assertEquals("Nathan", result.getName());
        assertEquals("Nath", result.getNickName());
        assertEquals(Integer.valueOf(44), result.getAge());

    }

}