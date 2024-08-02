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

	public void delete(int i) {
		// TODO Auto-generated method stub
		commentRepository.deleteById(i);
	}

	public Iterable<Comment> getComments() {
		// TODO Auto-generated method stub
		
		return commentRepository.findAll();
	}

	
	

}
