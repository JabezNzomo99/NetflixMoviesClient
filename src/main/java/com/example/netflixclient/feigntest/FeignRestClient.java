package com.example.netflixclient.feigntest;

import com.example.netflixclient.models.User;
import com.example.netflixclient.models.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "netflix",url = "http://localhost:8080", configuration = FeignLogConfig.class)
public interface FeignRestClient {

    @RequestMapping(method = RequestMethod.POST, value = "users", consumes = "application/json")
    public User addUser(@RequestBody User user);

    @RequestMapping(method = RequestMethod.GET, value = "users")
    public List<User> getAllUsers();

    @RequestMapping(method = RequestMethod.POST, value = "categories")
    public Category addCategory(Category category);

    @RequestMapping(method = RequestMethod.GET, value = "categories")
    public  List<Category> getCategories();

    @GetMapping(value = "movies")
    public List<Movie> getAllMovies();

    @RequestMapping(method = RequestMethod.GET, value = "movies/{categoryId}")
    public List<Movie> getMoviesPerCategoryAndType(@PathVariable(name = "categoryId") Long categoryId,
                                                   @RequestParam(name = "movieType") MovieType movieType);


    @RequestMapping(method = RequestMethod.GET, value = "my_movies/{userId}")
    public List<Movie> getUserMovies(@PathVariable(name = "userId") Long userId);

    @RequestMapping(method = RequestMethod.GET, value = "movies/search/{movieId}")
    public Movie getMovieById(@PathVariable(name = "movieId") Long movieId);

    @RequestMapping(method = RequestMethod.GET, value = "movies/search")
    public List<Movie> searchMovieByName(@RequestParam(name = "movieName") String movieName);

    @RequestMapping(method = RequestMethod.GET, value = "movies/category/{categoryName}")
    public List<Movie> getMoviesByCategoryName(@PathVariable(name = "categoryName") String categoryName);

    @RequestMapping(method = RequestMethod.POST, value = "movies/{userId}")
    public Movie suggestMovie(@PathVariable(name = "userId") Long userId,
                              @RequestBody MovieDto movieDto);

    @RequestMapping(method = RequestMethod.PATCH, value = "movies/{userId}/{movieId}")
    public Movie updateMovie(@PathVariable(name = "userId") Long userId,
                             @PathVariable(name = "movieId") Long movieId,
                             @RequestBody MovieDto movieDto);

    @RequestMapping(method = RequestMethod.DELETE, value = "movies/{userId}/{movieId}")
    public void deleteMovie(@PathVariable(name = "movieId") Long movieId,
                            @PathVariable(name = "userId") Long userId);

    @RequestMapping(method = RequestMethod.GET, value = "movies/type")
    public List<Movie> findMoviesByMovieType(@RequestParam(name = "movieType") MovieType movieType);

}
