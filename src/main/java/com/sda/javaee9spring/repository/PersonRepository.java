package com.sda.javaee9spring.repository;


import com.sda.javaee9spring.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    // based on the name of that method Spring is going to build sql query for us
    // Spring is using class properties to build the query: like name, surname, id or age.
    // use it only for simple cases (short method names)!!!
    // for complicated or long sql queries use @Query annotation
    boolean existsByNameAndSurname(String name, String surname);

    // we cn provide our own query and Spring with Hibernate are going to use it.
    // It's very useful for longer queries
    // we've got two options here:
    // using native sql-s (with nativeQuery set to true) or JPQL (with nativeQuery set to false)
    // JPQL - Java Persistence Query Language - subset of SQL
    @Query(value = """
    SELECT COUNT (*) > 0
    FROM PERSON_ENTITIES
    WHERE name = :name AND surname = :surname
""", nativeQuery = true)
    boolean checkDuplicates(String name, String surname);

}
