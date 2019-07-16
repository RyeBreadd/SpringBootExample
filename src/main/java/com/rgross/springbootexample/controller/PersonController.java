package com.rgross.springbootexample.controller;

import com.rgross.springbootexample.model.Person;
import com.rgross.springbootexample.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PersonController {

    @Autowired
    PersonServiceImpl personServiceImpl;

    @GetMapping(value = "/ping", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity ping() {
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Person>> test() {
        List<Person> people = personServiceImpl.getAllPeople();
        return ResponseEntity.ok(people);
    }

    @PostMapping(value = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addPerson(@RequestBody Person person) {
        personServiceImpl.addPerson(person);
        return ResponseEntity.ok("Successfully added");
    }
}
