package com.example.netflixclient.feigntest;

import com.example.netflixclient.models.*;
import feign.FeignException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FeignRestClientTest implements CommandLineRunner {

    private final FeignRestClient feignRestClient;
    private User createdUser = new User("Test",1234L);
    Movie testMovie = new Movie();

    public FeignRestClientTest(FeignRestClient feignRestClient) {
        this.feignRestClient = feignRestClient;
    }

    @Override
    public void run(String... args) throws Exception {

        //Create User
        try {
            createdUser = feignRestClient.addUser(new User("Test", 1234L));
            System.out.println(createdUser.toString());
        } catch (FeignException exception) {
            System.out.println(exception.getMessage());
        }

        //Admin Purposes - Display a list of users
        List<User> allUsers = feignRestClient.getAllUsers();
        System.out.println(allUsers.toString());

        //Admin add category
        Category addedCategory = feignRestClient.addCategory(new Category("POP"));
        System.out.println(addedCategory.toString());

        //Retrieve all categories
        List<Category> categoryList = feignRestClient.getCategories();
        System.out.println(categoryList.toString());

        //Retrieve All Movies
        List<Movie> movieList = feignRestClient.getAllMovies();
        System.out.println(movieList.toString());

        //Retrieve movies by category and type
        try {
            List<Movie> movieList1 = feignRestClient.getMoviesPerCategoryAndType(6L, MovieType.ORIGINAL);
            System.out.println(movieList1.toString());
        }catch (FeignException exception){
            System.out.println(exception.getMessage());
        }

        //Suggest Movie
        try{
            testMovie.setMovieName("Jamie Jamie");
            ArrayList<Long> categoriesId = new ArrayList<>();
            categoriesId.add(1L);
            testMovie.setYearOfRelease("2015");
            testMovie = feignRestClient.suggestMovie(createdUser.getIdentificationNumber(),
                    new MovieDto( testMovie, categoriesId));
            System.out.println(testMovie.toString());
        }catch(FeignException exception) {
            System.out.println(exception.getMessage());
        }

        //Get User Movies
        try{
            List<Movie> userMovies = feignRestClient.getUserMovies(createdUser.getIdentificationNumber());
            System.out.println(userMovies.toString());
        }catch (FeignException e){
            System.out.println(e.getMessage());
        }

        //Update user's movie
        try{
            ArrayList<Long> categoriesId = new ArrayList<>();
            categoriesId.add(1L);
            testMovie.setMovieId(11L);
            Movie updatedMovie = new Movie();
            updatedMovie.setMovieName("Updated Movie");
            updatedMovie.setYearOfRelease("2010");
            updatedMovie  = feignRestClient.updateMovie(1234L, testMovie.getMovieId(),
                    new MovieDto( updatedMovie, categoriesId));
            System.out.println(updatedMovie.toString());
        }catch (FeignException exception){
            exception.printStackTrace();
        }



        //Get Movie by movie id
        try{
            Movie searchedMovieById = feignRestClient.getMovieById(11L);
            System.out.println(searchedMovieById.toString());
        }catch (FeignException exception){
            System.out.println(exception.getMessage());
        }

        //Search movie by name
        try {
            List<Movie> searchedMoviesByName = feignRestClient.searchMovieByName("50 shades");
            System.out.println(searchedMoviesByName.toString());
        }catch (FeignException e){
            e.printStackTrace();
        }

        //get movies by category name
        try {
                List<Movie> moviesByCategoryName = feignRestClient.getMoviesByCategoryName("Action");
                System.out.println(moviesByCategoryName.toString());
        }catch (FeignException e){
            e.printStackTrace();
        }


        //Get movies by movie type
        try {
            List<Movie> moviesByMovieType = feignRestClient.findMoviesByMovieType(MovieType.ORIGINAL);
            System.out.println(moviesByMovieType.toString());
        }catch (FeignException e){
            e.printStackTrace();
        }

        //Delete a users movie
        try{
            feignRestClient.deleteMovie(testMovie.getMovieId(),createdUser.getIdentificationNumber());
            List<Movie> allMovies = feignRestClient.getAllMovies();
            System.out.println(allMovies.toString());
        }catch (FeignException feignException){
            feignException.printStackTrace();
        }


    }
}
