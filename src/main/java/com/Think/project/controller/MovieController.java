package com.Think.project.controller;

import com.Think.project.bean.Movie;
import com.Think.project.bean.MovieName;
import com.Think.project.config.configuration;
import com.google.gson.internal.$Gson$Preconditions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

    @Autowired
    configuration config;
    /**
     * Get all users list.
     *
     * @return the list
     */
    @GetMapping("/allMovies")
    public List<Movie> getAllMovie() {
        return config.k;
    }

    @RequestMapping(path = "/movie",consumes = {"application/JSON", "application/XML"},method = RequestMethod.POST,
            produces = {"application/JSON","application/XML"} )

    public ResponseEntity<Object> getMovie(@RequestBody MovieName moviename) {
        List m= config.k.stream().filter(k->k.getTitle().equals(moviename.getMovieName())).collect(Collectors.toList());
        if(config.k.stream().filter(k->k.getTitle().equals(moviename.getMovieName())).collect(Collectors.toList()).size()>=1){
            return ResponseEntity.ok(m.get(0));
        }
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(path = "/movielist",consumes = {"application/JSON", "application/XML"},method = RequestMethod.POST,
            produces = {"application/JSON","application/XML"} )

    public ResponseEntity<Object> getMovielistsorted(@RequestBody MovieName moviename) {
        if (moviename.getSort().equalsIgnoreCase("title")) {
            if (moviename.getOrder().equalsIgnoreCase("asc")) {
                config.k.sort(Comparator.comparing(Movie::getTitle));
                return ResponseEntity.ok(config.k);
            } else {
                config.k.sort(Comparator.comparing(Movie::getTitle).reversed());

                return ResponseEntity.ok(config.k);

            }
        }else if (moviename.getSort().equalsIgnoreCase("Release Date")) {
            if (moviename.getOrder().equalsIgnoreCase("asc")) {
                config.k.sort(Comparator.comparing(Movie::getRelease_Date));
                return ResponseEntity.ok(config.k);
            } else {
                config.k.sort(Comparator.comparing(Movie::getRelease_Date).reversed());

                return ResponseEntity.ok(config.k);

            }
        }else {
            return ResponseEntity.notFound().build();
        }
    }






}
