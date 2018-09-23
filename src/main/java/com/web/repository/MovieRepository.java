package com.web.repository;

import org.springframework.data.repository.CrudRepository;

import com.web.classes.Movie;

public interface MovieRepository extends CrudRepository<Movie, String>{

}
