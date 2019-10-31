package com.example.netflixclient.models;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public class MovieDto {


    @Valid
    private Movie movie;

    private List<Long> categories;

    public MovieDto(Movie movie, List<Long> categories) {
        this.movie = movie;
        this.categories = categories;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Long> getCategories() {
        return categories;
    }

    public void setCategories(List<Long> categories) {
        this.categories = categories;
    }
}
