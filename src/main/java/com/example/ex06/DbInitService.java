package com.example.ex06;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbInitService {
    @Autowired
    private PersonRepository repository;
    @PostConstruct
    public void init() {
        Person person1 = new Person(1, "Mert", "Caliskan", "emailaddress@gmail.com");
        repository.save(person1);
        Person person2 = new Person(2, "Steve", "Millidge", "emailaddress1@c2b2.co.uk");
        repository.save(person2);
        Person person3 = new Person(3, "Andrew", "Pielage", "emailaddress2@c2b2.co.uk");
        repository.save(person3);
    }
}
