package com.openclassrooms.datalayer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.datalayer.model.Comment;
import com.openclassrooms.datalayer.model.Product;
import com.openclassrooms.datalayer.repository.CommentRepository;
import com.openclassrooms.datalayer.repository.ProductRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	
	public Optional<Comment> getCommentById(Integer id) {
		return commentRepository.findById(id);
	}
	

}
