package com.openclassrooms.datalayer.repository;

import org.springframework.data.repository.CrudRepository;
import com.openclassrooms.datalayer.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

}
