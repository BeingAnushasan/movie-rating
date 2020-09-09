package com.tiger.movierating.services;

import com.tiger.movierating.models.Movie;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Optional;

public interface MovieService {
    Movie create(Movie movie);

    List<Movie> findAll();

    Optional<Movie> findOneByID( Long id);

    Movie update(Long id, Movie movie);

    void delete(Long id);
    void deleteAll();


}
