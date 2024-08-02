package com.openclassrooms.datalayer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.datalayer.model.Product;
import com.openclassrooms.datalayer.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public Iterable<Product> getProducts() {
		return productRepository.findAll();
	}
	
	public Optional<Product> getProductById(Integer id) {
		return productRepository.findById(id);
	}

	public Product addProduct(Product newProduct) {
		// TODO Auto-generated method stub
		return productRepository.save(newProduct);
	}

	public void delete(int i) {
		// TODO Auto-generated method stub
		productRepository.deleteById(i);
	}

	public Iterable<Product> getProductsByName(String name) {
		// TODO Auto-generated method stub
		return productRepository.findByName(name);
	}
	
	public Iterable<Product> getProductsByCategoryName(String name) {
		// TODO Auto-generated method stub
		return productRepository.findByCategoriesName(name);
	}
	


}
