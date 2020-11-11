package com.tiger.movierating.services;

import com.tiger.movierating.models.Movie;
import com.tiger.movierating.models.UserDetails.User;
import com.tiger.movierating.repos.*;
import com.tiger.movierating.util.CurrentUserProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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


    public Movie create( Movie movie ){
//        String username = new CurrentUserProvider().getUsername();
//        movie.setOwner( username );
        return movieRepo.save( movie );
    }


    public List<Movie> findAll(){
        String username = new CurrentUserProvider().getUsername();
        System.out.println( "The security context returned: " + username );
//        User byUsername = userRepo.findByUsername( username );
        return movieRepo.findByOwner( username );
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
