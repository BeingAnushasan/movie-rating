package com.tiger.movierating.services;

import com.tiger.movierating.models.Movie;
import com.tiger.movierating.models.UserDetails.User;
import com.tiger.movierating.repos.*;
import org.springframework.stereotype.Service;

import java.security.Principal;
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


    public void create( Movie movie, Principal principal ){
        User byUsername = userRepo.findByUsername( principal.getName() );
        byUsername.getMovie().add( movie );
        userRepo.save( byUsername );
    }


    public List<Movie> findAll( String principle ){
        User byUsername = userRepo.findByUsername( principle );
        return byUsername.getMovie();
    }

    public Optional<Movie> findOneByID( Long id ){
        return movieRepo.findById( id );
    }

    public Movie update( Long id, Movie movie ){
        if (movieRepo.existsById( id )) {

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

    public void deleteByID( Long id, String username ){
        User byUsername = userRepo.findByUsername( username );
        byUsername.getMovie().removeIf( movie -> movie.getId().equals( id ) );
        userRepo.save( byUsername );
//        movieRepo.deleteById( id );
    }
}
