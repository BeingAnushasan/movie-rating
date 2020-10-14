package com.tiger.movierating.services;

import com.tiger.movierating.models.Movie;
import com.tiger.movierating.repos.MovieRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl  {
    final MovieRepo movieRepo;

    public MovieServiceImpl( MovieRepo movieRepo ){
        this.movieRepo = movieRepo;
    }


    public Movie create( Movie movie ){
        return movieRepo.save( movie );
    }

    public List<Movie> findAll(){
        System.out.println( "In the service impl part before list creation" );
        System.out.println( "In the service impl part" );
        return movieRepo.findAll();
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
        return movieRepo.findByMovieName(name);
    }

    public void deleteByID( Long id ){
        movieRepo.deleteById( id );
    }
}
