package com.tiger.movierating.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie {

   @Id
   @GeneratedValue
   private Long id;

   private String movieName;

   @ElementCollection
   public List<String> genre = null;

   private String releaseYear;
   private String timeLength;
   private String language;
   private String director;
   @ElementCollection
   private List<String> mainActors;
   private String rating;
   private double imdbRating;
   private String description;

}
