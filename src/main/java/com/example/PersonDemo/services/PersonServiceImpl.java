package com.example.PersonDemo.services;

import com.example.PersonDemo.models.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    public PersonServiceImpl() {
        System.out.println(">> SERVICE started.");
    }

    @Override
    public Person getPerson(String name, String nickName, String age) {
        return new Person(name, nickName,age);
    }
}
