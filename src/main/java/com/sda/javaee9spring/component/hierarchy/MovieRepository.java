package com.sda.javaee9spring.component.hierarchy;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {
    public List<Movie> readAllMoviesFromDatabase(){
        return List.of();
    }
}
