package com.tunerart.shop.controller;

import com.tunerart.shop.entity.Person;
import com.tunerart.shop.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/newPerson")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        return ResponseEntity.ok(personService.newPerson(person));
    }

    @GetMapping("/personById/{personId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Person> getPersonById(@PathVariable Long personId) {
        Person person = personService.getPersonById(personId);
        return ResponseEntity.ok(person);
    }

}
