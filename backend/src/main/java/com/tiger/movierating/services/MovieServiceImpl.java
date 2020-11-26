package com.tiger.movierating.services;

import com.tiger.movierating.models.Movie;
import com.tiger.movierating.repos.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl {

    final UserRepo userRepo;
    final MovieRepo movieRepo;


    public MovieServiceImpl( MovieRepo movieRepo, UserRepo userRepo ){
        this.movieRepo = movieRepo;
        this.userRepo = userRepo;
    }


    public void create( Movie movie ){
         movieRepo.save( movie );
    }


    public List<Movie> findAll(String principle){
//        String username = principle
//        System.out.println( "The security context returned: " + principle );
//        User byUsername = userRepo.findByUsername( username );
        return movieRepo.findByOwner( principle );
    }

    public Optional<Movie> findOneByID( Long id ){
        return movieRepo.findById( id );
    }

    public Movie update( Long id, Movie movie ){
        if (movieRepo.existsById( id )) {
            movie.setId( id );
            return movieRepo.save( movie );
        } else return movie;
    }

    public void delete( Long id ){
        movieRepo.deleteById( id );
    }

    public void deleteAll(){
        movieRepo.deleteAll();
    }

    public List<Movie> findByGenre( String genre ){
        return movieRepo.findByGenre( genre );
    }


    public List<Movie> findByName( String name ){
        return movieRepo.findByMovieName( name );
    }

    public void deleteByID( Long id ){
        movieRepo.deleteById( id );
    }
}
