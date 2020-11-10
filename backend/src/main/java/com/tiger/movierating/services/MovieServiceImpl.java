package com.tiger.movierating.services;

import com.tiger.movierating.models.Movie;
import com.tiger.movierating.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl {
    @Autowired
    UserRepo userRepo;
    final MovieRepo movieRepo;


    public MovieServiceImpl( MovieRepo movieRepo ){
        this.movieRepo = movieRepo;
    }


    public Movie create( Movie movie ){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println( "The esc context returned: "+principal );
        return movieRepo.save( movie );
//        userRepo.save( movie );
    }


    public List<Movie> findAll(Long id){
//        return movieRepo.findAll();
        return  movieRepo.findByUserId(id);
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
