package com.sda.javaee9spring.controller;

import com.sda.javaee9spring.entity.Person;
import com.sda.javaee9spring.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/person")
public class PersonController {

    public static final String PERSONS_KEY = "persons";

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/names")
    public String showListOfPersonsNames(Model data){
        var persons = personService.getAllPersons();

        data.addAttribute(PERSONS_KEY, persons);
        return "persons/persons-names";
    }
}
