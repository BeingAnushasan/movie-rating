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
//        List<Movie> listOfNewMovies = new ArrayList<>();
//        listOfNewMovies.add(
//                new Movie( 111111000L, "Ek Tha tiger", List.of(Genre.ACTION, Genre.ROMANCE, Genre.DRAMA) ,"2013", "2hr 45min", "Hindi", "Rohit Shetty",
//                        List.of( "Salman Khan", "Katrina Kaif" ), 8.5, 7.5, "A action movie of Salman Khan" ) );
//        listOfNewMovies.add(
//                new Movie( 1111110001L, "Ek Tha tiger 2", List.of(Genre.ACTION, Genre.ROMANCE) , "2018", "2hr 45min", "Hindi", "Rohit Shetty",
//                        List.of( "Salman Khan", "idk " ), 8.0, 7.0, "A action movie of Salman Khan" ) );
//
//        listOfNewMovies.stream().forEach( movieRepo::save );
//
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


}
