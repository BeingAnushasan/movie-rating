package com.tiger.movierating.controllers;

import com.tiger.movierating.models.Movie;
import com.tiger.movierating.services.MovieServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@CrossOrigin
public class BasicMovieController {

    final MovieServiceImpl movieService;

    public BasicMovieController( MovieServiceImpl movieService ){
        this.movieService = movieService;
    }

    @GetMapping("/movie")
    public List<Movie> getAllMovies(){
        List<Movie> movieList = movieService.findAll();
        return movieList;
    }

    @PostMapping("/movie")
    public void printReceivedData( @RequestBody Movie payload ){
        System.out.println( "Saving to Database" + payload );
        movieService.create( payload );
    }

    @GetMapping("/search")
    public Set<Movie> searchByGenre( @RequestParam Map<String, String> requestParams ){
        String name = requestParams.get( "name" );
        String genre = requestParams.get( "genre" );
        System.out.println( "Name:" + name + "   Genre:" + genre );
        List<Movie> byName = movieService.findByName( name );
        List<Movie> byGenre = movieService.findByGenre( genre );
        return Stream.concat( byName.stream(), byGenre.stream() ).collect( Collectors.toSet() );
    }

    @DeleteMapping("/movie/{id}")
    public void deleteMovie( @PathVariable Long id ){

        movieService.deleteByID( id );
    }


}
