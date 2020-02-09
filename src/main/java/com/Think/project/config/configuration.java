package com.Think.project.config;

import com.Think.project.bean.Movie;
import com.Think.project.dao.FetchAllMovieList;
import com.Think.project.service.MovieService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration("application")
public class configuration {
    @Value("${moviename}")
    String moviename;
    public List<Movie> k = new ArrayList<>();

   @PostConstruct
 public void getlist(){
       MovieService movieService=new MovieService();
       k=movieService.fetchMovie(moviename);
 }

}
