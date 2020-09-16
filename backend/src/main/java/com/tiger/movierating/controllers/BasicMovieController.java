package com.tiger.movierating.controllers;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.tiger.movierating.models.Movie;
import com.tiger.movierating.models.TestMovie;
import com.tiger.movierating.services.MovieServiceImpl;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class BasicMovieController {

    @Autowired
    MovieServiceImpl movieService;

    @GetMapping("/movie")
    public List<Movie> getAllMovies(){
//        System.out.println( "In the controller part" );
        return movieService.findAll();
    }

//    @PostMapping("/test")
//    public void printReceivedData( @RequestBody Map<String, Object> payload ) throws Exception{
//        System.out.println( payload );
//    }

    @PostMapping("/test")
    public void printReceivedData( @RequestBody Movie payload ) throws Exception{
        System.out.println( "Saving to Database"+payload );
        movieService.create( payload );
    }

    @GetMapping("/deletemovie")
    public void deleteAllMovies(){
        movieService.deleteAll();
    }

}
