package com.example.netflixclient.models;

import java.util.HashSet;
import java.util.Set;

public class Category {


    private Long categoryId;

    private String categoryName;

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    private Set<Movie> movies = new HashSet<>();

    public Category(){}

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                " Category Id:"+categoryId+
                " Category Name:"+categoryName+
                "}";
    }
}
