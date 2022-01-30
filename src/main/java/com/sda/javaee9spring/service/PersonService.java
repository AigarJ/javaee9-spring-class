package com.sda.javaee9spring.service;

import com.sda.javaee9spring.entity.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    public List<Person> getAllPersons(){
        // with var Java is going to guess type of the variable based on assigned value
//        var name = "mariusz"; // String name = "mariusz";
//        var mariusz = new Person("Mariusz", "Pastuszka", 18);
//        Person mariusz = new Person("Mariusz", "Pastuszka", 18);
//        var mariusz = null; // need initialization value, without that it won't work
        ArrayList<Person> myBestFriends = new ArrayList<Person>(); // till Java 7
        ArrayList<Person> myBestFriendsJava7 = new ArrayList<>(); // since Java 7
        var myBestFriendsJava10 = new ArrayList<Person>(); // since Java 10
        var myBestFriendsJava10v2 = new ArrayList<>(); // since Java 10
        var myBestFriendsJava10v3 = new ArrayList<Object>(); // since Java 10

        // this list will be dynamic in the future:)
//        List<Person> persons

        var persons
                = List.of(
                new Person("Joe","Slim", 26),
                new Person("Maria", "Black", 27),
                new Person("Arnold", "Doe", 30)
        );
        return persons;
    }
}
