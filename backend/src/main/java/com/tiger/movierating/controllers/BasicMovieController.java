package com.tiger.movierating.controllers;

import com.tiger.movierating.models.Movie;
import com.tiger.movierating.services.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class BasicMovieController {

    @Autowired
    MovieServiceImpl movieService;

    @GetMapping("/movies")
    public List<Movie> getAllMovies(){
        System.out.println("In the controller part");
        return movieService.findAll();
    }

    @GetMapping("/deletemovies")
    public void deleteAllMovies(){
         movieService.deleteAll();
    }

}
