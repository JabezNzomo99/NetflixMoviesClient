package com.example.netflixclient.models;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


public class Movie {


    private Long movieId;

    private String movieName;


    private String yearOfRelease;

    private MovieType movieType;

    private Set<Category> categories = new HashSet<>();

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie(){

    }

    public Movie(String movieName, String yearOfRelease, MovieType movieType, Set<Category> categories) {
        this.movieName = movieName;
        this.yearOfRelease = yearOfRelease;
        this.movieType = movieType;
        this.categories = categories;
    }

    public Movie(String movieName, String yearOfRelease, MovieType movieType) {
        this.movieName = movieName;
        this.yearOfRelease = yearOfRelease;
        this.movieType = movieType;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(String yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "Movie Id : "+movieId+
                "Movie Name :"+movieName+
                "Year of Release:"+yearOfRelease+
                "Movie Type : "+movieType+
                "Categories"+categories+
                "}";
    }
}
