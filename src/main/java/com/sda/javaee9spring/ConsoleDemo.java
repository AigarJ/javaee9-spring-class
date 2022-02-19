package com.sda.javaee9spring;

import com.sda.javaee9spring.entity.PersonEntity;
import com.sda.javaee9spring.repository.PersonRepository;
import com.sda.javaee9spring.service.RealPersonService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ConsoleDemo {

    public static void main(String[] args) {
        System.out.println("My console app");

        PersonRepository mockRepo = new PersonRepository() {
            @Override
            public List<PersonEntity> findAll() {
                return Collections.emptyList();
            }

            @Override
            public List<PersonEntity> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<PersonEntity> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public <S extends PersonEntity> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends PersonEntity> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends PersonEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
                return null;
            }

            @Override
            public void deleteAllInBatch(Iterable<PersonEntity> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Long> longs) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public PersonEntity getOne(Long aLong) {
                return null;
            }

            @Override
            public PersonEntity getById(Long aLong) {
                return null;
            }

            @Override
            public <S extends PersonEntity> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends PersonEntity> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<PersonEntity> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends PersonEntity> S save(S entity) {
                return null;
            }

            @Override
            public Optional<PersonEntity> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(PersonEntity entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends PersonEntity> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends PersonEntity> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends PersonEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends PersonEntity> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends PersonEntity> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends PersonEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }
        };
        RealPersonService myService = new RealPersonService(mockRepo);
        myService.readAllPersonEntities();
    }
}
