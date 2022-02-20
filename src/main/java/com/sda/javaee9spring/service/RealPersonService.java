package com.sda.javaee9spring.service;

import com.sda.javaee9spring.entity.PersonEntity;
import com.sda.javaee9spring.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RealPersonService {

    private final PersonRepository personRepository;

    public RealPersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonEntity> readAllPersonEntities(){
        log.info("Trying to read all persons entities");

        var result = personRepository.findAll();
        log.info("Persons entities read from db: {}", result);
        return result;
    }
    public Optional<PersonEntity> readPersonEntityById(Long id){
        log.info("read entity by id: [{}]", id);

        Optional<PersonEntity> maybePerson = personRepository.findById(id);

        log.info("found Person entity: [{}]", maybePerson);
        return maybePerson;
    }

    @Transactional
    public boolean deletePersonEntityById(Long id){
        log.info("trying to delete entity by id: [{}]", id);

        boolean result = false;
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            result = true;
        }
        return result;
    }


    @Transactional
    public PersonEntity savePerson(PersonEntity entity){
        log.info("entity for saving: [{}]", entity);
        if (!personRepository.checkDuplicates(entity.getName(), entity.getSurname())) {
            personRepository.save(entity);
            log.info("entity after saving: [{}]", entity);
        } else {
            log.info("duplicate!!!");
        }
        return entity;
    }
}
