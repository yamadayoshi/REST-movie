package com.web.repository;

import org.springframework.data.repository.CrudRepository;

import com.web.classes.Category;

public interface CategoryRepository extends CrudRepository<Category, String> {

}
