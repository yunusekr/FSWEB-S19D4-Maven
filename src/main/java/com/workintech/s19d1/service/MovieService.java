package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<Movie> findAll();

    Movie findById(Long id);

    Movie save(Movie movie);

    Movie update(Long id, Movie movie);

    void delete(Movie movie);
}