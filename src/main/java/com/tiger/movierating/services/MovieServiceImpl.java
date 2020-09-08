package com.tiger.movierating.services;

import com.tiger.movierating.models.Genre;
import com.tiger.movierating.models.Movie;
import com.tiger.movierating.repos.MovieRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    final MovieRepo movieRepo;

    public MovieServiceImpl( MovieRepo movieRepo ){
        this.movieRepo = movieRepo;
    }


    @Override
    public Movie create( Movie movie ){
        return movieRepo.save( movie );
    }

    @Override
    public List<Movie> findAll(){
        System.out.println( "In the service impl part before list creation" );
        List<Movie> listOfNewMovies = new ArrayList<>();
        listOfNewMovies.add(
                new Movie( 111111000L, "Ek Tha tiger", List.of(Genre.ACTION, Genre.ROMANCE, Genre.DRAMA) ,"2013", "2hr 45min", "Hindi", "Rohit Shetty",
                        List.of( "Salman Khan", "Katrina Kaif" ), 8.5, 7.5, "A action movie of Salman Khan" ) );
        listOfNewMovies.add(
                new Movie( 1111110001L, "Ek Tha tiger 2", List.of(Genre.ACTION, Genre.ROMANCE) , "2018", "2hr 45min", "Hindi", "Rohit Shetty",
                        List.of( "Salman Khan", "idk " ), 8.0, 7.0, "A action movie of Salman Khan" ) );

        listOfNewMovies.stream().forEach( movieRepo::save );
        
        System.out.println( "In the service impl part" );
        return movieRepo.findAll();
    }

    @Override
    public Optional<Movie> findOneByID( Long id ){
        return movieRepo.findById( id );
    }

    @Override
    public Movie update( Long id, Movie movie ){
        if (movieRepo.existsById( id )) {
            movie.setId( id );
            return movieRepo.save( movie );
        } else return movie;
    }

    @Override
    public void delete( Long id ){
        movieRepo.deleteById( id );
    }
}
