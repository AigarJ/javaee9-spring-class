package com.sda.javaee9spring.controller;

import com.sda.javaee9spring.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/person")
public class PersonController {

    public static final String PERSONS_KEY = "personsKey";

    @GetMapping("/names")
    public String showListOfPersonsNames(Model data){
        var persons
        = List.of(
                new Person("Aigar","Jurise", 26),
                new Person("Maria", "Black", 27),
                new Person("Arnold", "Doe", 30)
        );
        data.addAttribute(PERSONS_KEY, persons);
        return "persons/persons-names";
    }
}
