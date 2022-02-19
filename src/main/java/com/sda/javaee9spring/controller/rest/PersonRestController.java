package com.sda.javaee9spring.controller.rest;


import com.sda.javaee9spring.entity.PersonEntity;
import com.sda.javaee9spring.service.RealPersonService;
import com.sun.xml.bind.v2.TODO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/api")
public class PersonRestController {

    private final RealPersonService personService;


    @Autowired
    public PersonRestController(RealPersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public List<PersonEntity> findAllPersons(){
        log.info("findAllPersons()");

        return personService.readAllPersonEntities();
    }

    // /persons/1
    // /persons/10
    // /persons/123456
    @GetMapping("/persons/{id}")
    public ResponseEntity<PersonEntity> findPersonEntityById(@PathVariable("id") Long personId) {
        log.info("trying to find person entity by id: [{}]", personId);
        var personEntity = personService.readPersonEntityById(personId);
        return personEntity.map(personEntity1 -> ResponseEntity.ok(personEntity1)) // Optional<PersonEntity> -> Optional<ResponseEntity<PersonEntity>>
                .orElseGet(() -> ResponseEntity.notFound().build());

//
//        if (personEntity.isEmpty()) {
//            PersonEntity personEntityFromOptional = personEntity.get();
//            return ResponseEntity.notFound().build();
//        }
////            return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);;
//
//        return ResponseEntity.ok(personEntity);
////        return new ResponseEntity<>(personEntity, null, HttpStatus.OK);
    }

    // /persons/1 - using DELETE HTTP VERB
    @DeleteMapping("/persons/{id}")
    public ResponseEntity<Void> deletePersonEntityById(@PathVariable("id") Long id){
        log.info("trying to delete person entity by id: [{}]", id);

        boolean deleted = personService.deletePersonEntityById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
