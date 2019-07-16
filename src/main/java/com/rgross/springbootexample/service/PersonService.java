package com.rgross.springbootexample.service;

import com.rgross.springbootexample.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPeople();
    void addPerson(Person person);
}
