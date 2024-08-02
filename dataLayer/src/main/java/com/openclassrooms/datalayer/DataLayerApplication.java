package com.openclassrooms.datalayer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.openclassrooms.datalayer.model.Product;
import com.openclassrooms.datalayer.service.CategoryService;
import com.openclassrooms.datalayer.service.CommentService;
import com.openclassrooms.datalayer.service.ProductService;

import jakarta.transaction.Transactional;

import com.openclassrooms.datalayer.model.Category;
import com.openclassrooms.datalayer.model.Comment;


 
@SpringBootApplication
public class DataLayerApplication implements CommandLineRunner {
 
	@Autowired
	private ProductService productService;
	// On obtient ainsi un objet instancié correspondant à la classe ProductService.
	
	@Autowired
	private CategoryService categoryService;
	
	
	@Autowired
	private CommentService commentService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DataLayerApplication.class, args);
	}
 
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		
		/*
		System.out.println("I - Produits==================");
		Iterable<Product> products = productService.getProducts();
		products.forEach(product -> System.out.println(product.getProductId() + " "+ product.getName() + " " + product.getCost()));
		
		System.out.println("");
		
		System.out.println("II - Categories==================");
		Iterable<Category> categories = categoryService.getCategorys();
		categories.forEach(category -> System.out.println(category.getName()));
		
		System.out.println("");
		
		System.out.println("III - Produit 1==================");
		Optional<Product> optionalProduct = productService.getProductById(20);
		
		Product thisProduct = optionalProduct.get();
		System.out.println(thisProduct.getName());
		
		System.out.println("");
		
		System.out.println("IV - Category 1==================");
		Optional<Category> optionalCategory = categoryService.getCategoryById(1);
		Category thisCategory = optionalCategory.get();
		System.out.println(thisCategory.getName());
		
		System.out.println("");
		
		System.out.println("V - Tous les produits associées à la catégorie 1=======");
		thisCategory.getProducts().forEach(anotherProduct -> System.out.println(anotherProduct.getName()));
		
		System.out.println("");
		
		System.out.println("VI - Afficher le produit associé au commentaire 1=======");
		Optional<Comment>  optionalComment = commentService.getCommentById(1);
		Comment thisComment = optionalComment.get();
		Product anotherProduct = thisComment.getProduct();
		System.out.println(anotherProduct.getName());
		
		System.out.println("");
		
		System.out.println("VII - Commentaires du produit 1=======");
		thisProduct.getComments().forEach(oneComment -> System.out.println(oneComment.getContent()));
		
		
		System.out.println("");
		
		System.out.println("VIII - Ajout d'une nouvelle catégory Risque mineur");
		Category newCategory = new Category();
		newCategory.setName("Risque mineur");
		newCategory = categoryService.addCategory(newCategory);
		categoryService.getCategorys().forEach(
		category -> System.out.println(category.getCategoryId() + category.getName()));		
		*/
		
		/*
		System.out.println("VIII - Ajout d'une nouveau produit Assurance foulage petit doigt 3");
		Product newProduct = new Product();
		newProduct.setName("Assurance foulage petit doigt 3");
		newProduct.setCost(100);
		newProduct.setDescription("En cas de surmenage dans les ministères");
		
		
		
		newCategory.addProduct(newProduct);
		newProduct = productService.addProduct(newProduct);
		Iterable<Product> anyproducts = productService.getProducts();
		anyproducts.forEach(product -> System.out.println(product.getName()));
		*/
		
		/*
		System.out.println("");
		
		System.out.println("IX - modification d'un produit");
		Product existingProduct = productService.getProductById(1).get();
		System.out.println("cout actuel " + existingProduct.getCost());
		existingProduct.setCost(7000);
		productService.addProduct(existingProduct);
		Iterable<Product> allproducts = productService.getProducts();
		allproducts.forEach(product -> System.out.println(product.getName()));
		*/
		
		/*
		System.out.println("");
		System.out.println("IX - suppression du produit 22");
		System.out.println("avant");
		Iterable<Product> othersproducts = productService.getProducts();
		othersproducts.forEach(product -> System.out.println(product.getProductId() + " "+ product.getName() + " " + product.getCost()));
		productService.delete(22);
		System.out.println("après");
		othersproducts = productService.getProducts();
		othersproducts.forEach(product -> System.out.println(product.getProductId() + " "+ product.getName() + " " + product.getCost()));
		*/
		
		/*
		System.out.println("");
		System.out.println("X - suppression du commentaire 2");
		System.out.println("avant");
		Iterable<Comment> somecomments = commentService.getComments();
		somecomments.forEach(comment -> System.out.println(comment.getCommentId() + comment.getContent()));
		commentService.delete(2);
		System.out.println("après");
		Iterable<Comment> anycomments = commentService.getComments();
		anycomments.forEach(comment -> System.out.println(comment.getCommentId() + comment.getContent()));
		
		
		System.out.println("");
		System.out.println("XI - suppression de la catégory 3");
		System.out.println("====avant=====");
		Iterable<Category> someCategorys = categoryService.getCategorys();
		someCategorys.forEach(category -> System.out.println(category.getCategoryId() + category.getName()));
		Iterable<Product> someProducts = productService.getProducts();
		someProducts.forEach(product -> System.out.println(product.getProductId() + " "+ product.getName() + " " + product.getCost()));
		categoryService.delete(3);
		System.out.println("====après===");
		Iterable<Category> anyCategorys = categoryService.getCategorys();
		anyCategorys.forEach(category -> System.out.println(category.getCategoryId() + category.getName()));
		someProducts = productService.getProducts();
		someProducts.forEach(product -> System.out.println(product.getProductId() + " "+ product.getName() + " " + product.getCost()));
		*/
		
		
		/*
		System.out.println("====avant=====");
		Iterable<Product> someProducts = productService.getProducts();
		
		
		someProducts.forEach(product -> System.out.println(product.getProductId() + " "+ product.getName() + " " + product.getCost()));
		System.out.println("====après===");
		Iterable<Product> searchResults = productService.getProductsByName("foulage");
		searchResults.forEach(product -> System.out.println(product.getName()));	
		
		searchResults.forEach(product -> productService.delete(product.getProductId()));
		
		someProducts = productService.getProducts();
		someProducts.forEach(product -> System.out.println(product.getProductId() + " "+ product.getName() + " " + product.getCost()));
		*/
	
		
		Iterable<Product> searchResults = productService.getProductsByName("Assurance débiles mentaux");
		searchResults.forEach(product -> System.out.println(product.getProductId()));	
		
		searchResults = productService.getProductsByCategoryName("Standard");
		searchResults.forEach(product -> System.out.println(product.getProductId()));	
	
	}
	
	
 
}
