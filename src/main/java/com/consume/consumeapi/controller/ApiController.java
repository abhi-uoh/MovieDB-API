package com.consume.consumeapi.controller;

import com.consume.consumeapi.Entities.Movie;
import com.consume.consumeapi.Entities.MovieData;
import com.consume.consumeapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ApiController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private MovieRepository repository;
    private static String url= "https://api.themoviedb.org/3/discover/movie?api_key=8c4c63a228db55743cff53868b3124af&year=";

    //https://api.themoviedb.org/3/discover/movie?api_key=8c4c63a228db55743cff53868b3124af&year=

//    ResponseEntity<Movie[]> response =
//            restTemplate.getForEntity(
//                    "http://localhost:8080/yr/",
//                    Movie[].class);
//    Movie[] employees = response.getBody();

    @GetMapping("/{yr}") //http://localhost:8082/2000
    public List<Movie> getCountries(@PathVariable int yr){
//        Object year =restTemplate.getForObject(url+yr,Object.class,"8c4c63a228db55743cff53868b3124af");

        ResponseEntity<MovieData> response =
            restTemplate.getForEntity(url+yr, MovieData.class);

//        return Arrays.asList(year);

        MovieData moviesData = response.getBody();
        List<Movie>movies = moviesData.getResults();
        for(Movie movie:movies){
            repository.save(movie);
        }
        return movies;
    }

}
