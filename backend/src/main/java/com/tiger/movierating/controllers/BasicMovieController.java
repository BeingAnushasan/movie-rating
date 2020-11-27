package com.tiger.movierating.controllers;

import com.tiger.movierating.models.Movie;
import com.tiger.movierating.services.MovieServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@CrossOrigin
@Transactional
public class BasicMovieController {

    final MovieServiceImpl movieService;

    public BasicMovieController( MovieServiceImpl movieService ){
        this.movieService = movieService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello There";
    }


    @GetMapping("/movie")
    public List<Movie> getAllMovies( Principal principal ){
        return movieService.findAll( principal.getName() );
    }

    @PostMapping("/movie")
    public void printReceivedData( @RequestBody Movie payload, Principal principal ){

        System.out.println( "Saving to Database" + payload );

        movieService.create( payload, principal );

    }

    @GetMapping("/search")
    public Object searchByGenre( @RequestParam Map<String, String> requestParams, Principal principal ){
        List<Movie> allMoviesOfCurrentUser = getAllMovies( principal );
        List<Movie> byGenre;
        List<Movie> byName = Collections.emptyList();

        String name = requestParams.get( "name" );
        String genre = requestParams.get( "genre" );
        System.out.println( "Searching for Name: " + name + " & Genre: " + genre );
        if (genre != "" || name != "") {
//            System.out.println( "Inside  if" );
            byGenre = allMoviesOfCurrentUser.stream().filter(
                    movie -> movie.getGenre().contains( genre ) ).collect(
                    Collectors.toList() );
            if (name != "") {
                byName = allMoviesOfCurrentUser.stream().filter(
                        movie -> movie.getMovieName().toLowerCase().contains( name.toLowerCase() ) ).collect(
                        Collectors.toList() );
            }
            return Stream.concat( byName.stream(), byGenre.stream() ).collect( Collectors.toSet() ).toArray();
        } else {
//            System.out.println( "Inside else" );
            return allMoviesOfCurrentUser;
        }


    }

    @DeleteMapping("/movie/{id}")
    public void deleteMovie( @PathVariable Long id , Principal principal){
        System.out.println( "Deleting movie of id: " + id );

        movieService.deleteByID( id , principal.getName());
    }


}
