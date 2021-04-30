package com.example.PersonDemo.models;

import com.example.PersonDemo.exceptions.InvalidAgeException;
import com.fasterxml.jackson.annotation.JsonInclude;

public class Person {

    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nickName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer age;

    public Person(String name, String nickName, String age) {
        this.name = name;
        this.nickName = nickName;
        setAge(age);
    }

    public String getName() {
        return name;
    }


    public String getNickName() {
        return nickName;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(String age) {
        try {
            this.age = (age != null) ? Integer.valueOf(age) : null;
        }
        catch (NumberFormatException e)
        {
            throw new InvalidAgeException("Invalid age supplied. Must be a valid number");
        }
    }
}
