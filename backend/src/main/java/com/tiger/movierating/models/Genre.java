package com.tiger.movierating.models;

public enum  Genre {
    ACTION(1),
    DRAMA(2),
    ROMANCE(3),
    HORROR(4),
    INDIE(5),
    WESTERN(6),
    Si_Fi(7);

    private int value;

    Genre(int value) { this.value = value; }

    public int getValue() { return value; }
}
