package com.web.repository;

import org.springframework.data.repository.CrudRepository;

import com.web.classes.Genre;

public interface GenreRepository extends CrudRepository<Genre, String> {

}
