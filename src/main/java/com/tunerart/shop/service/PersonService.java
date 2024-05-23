package com.tunerart.shop.service;

import com.tunerart.shop.entity.Person;
import com.tunerart.shop.repository.IPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final IPersonRepository personRepository;

    public Person newPerson(Person person) {
        return personRepository.save(person);
    }

    public Person getPersonById(Long personId) {
        Optional<Person> optionalPerson = personRepository.findById(personId);
        return optionalPerson.orElseThrow(
                () -> new RuntimeException("Not found person with this id"));
    }
}
