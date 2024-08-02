package com.openclassrooms.datalayer.repository;

import org.springframework.data.repository.CrudRepository;

import com.openclassrooms.datalayer.model.Category;

public interface CategoryRepository extends CrudRepository<Category,Integer>{

}
