package com.tiger.movierating.models;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Data
public class TestMovie {

    @Id
    @GeneratedValue
    private int id;
    public String movieName;
    public String description;
    public String rating;
    public List<String> genre = null;

}
