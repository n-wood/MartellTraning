package com.example.PersonDemo.models;

import com.example.PersonDemo.exceptions.BadRequestException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void setAge() {

        Person p = new Person("Nathan", "Nafe", "42");
        assertEquals("Nathan", p.getName());
        assertEquals("Nafe", p.getNickName());
        assertEquals(Integer.valueOf(42), p.getAge());
    }

    @Test
    void setInvalidAge() {

        assertThrows(BadRequestException.class, () -> {
            Person p = new Person("Nathan", "Nafe", "cheese");
        });


    }
}