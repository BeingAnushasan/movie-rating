package com.tiger.movierating.repos;

import com.tiger.movierating.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {
    @Query("SELECT m FROM Movie m JOIN m.genre g WHERE g= :genre")
   List<Movie> findByGenre( @Param("genre") String genre );

    @Query("SELECT m FROM Movie m Where m.movieName LIKE %:name% ")
    List<Movie>findByMovieName(@Param("name") String name );

//    @Query("SELECT m FROM Movie m Where m.userId LIKE %:id% ")
//    List<Movie> findByUserId(@Param("id") Long id);

//    @Query("SELECT m FROM Movie m Where m.owner LIKE %:username% ")
//    List<Movie> findByOwner( @Param("username") String username );
}
