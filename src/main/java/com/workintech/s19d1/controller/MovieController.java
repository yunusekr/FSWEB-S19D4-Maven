package com.workintech.s19d1.controller;


import com.workintech.s19d1.exceptions.ExceptionResponse;
import com.workintech.s19d1.service.MovieService;
import com.workintech.s19d1.entity.Movie;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    @GetMapping("/{id}")
    public Movie findById(@PathVariable long id) {
        Movie finded = movieService.findById(id);
        if(finded != null) {
            return finded;
        }
        return null;
    }

    @PostMapping
    public Movie save(@RequestBody Movie movie) {
        return movieService.save(movie);
    }

    @PutMapping("/{id}")
    public Movie update(@PathVariable long id, @RequestBody Movie updatedMovie) {
        return movieService.update(id, updatedMovie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        Movie findMovie = movieService.findById(id);
        movieService.delete(findMovie);
    }
}