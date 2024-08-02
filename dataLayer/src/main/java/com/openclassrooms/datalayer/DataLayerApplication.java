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
	public void run(String... args) throws Exception {
		
		
		System.out.println("I - Produits==================");
		Iterable<Product> products = productService.getProducts();
		products.forEach(product -> System.out.println(product.getName()));
		
		System.out.println("");
		
		System.out.println("II - Categories==================");
		Iterable<Category> categories = categoryService.getCategorys();
		categories.forEach(category -> System.out.println(category.getName()));
		
		System.out.println("");
		
		System.out.println("III - Produit 1==================");
		Optional<Product> optionalProduct = productService.getProductById(1);
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
		
		
 
		System.out.println("VIII - Ajout d'une nouveau produit Assurance foulage petit doigt");
		Product newProduct = new Product();
		newProduct.setName("Assurance foulage petit doigt 2");
		newProduct.setCost(100);
		newProduct.setDescription("En cas de surmenage dans les ministères");
		
		/* ajouter le produit à la catégorie afin de créer le lien avant l'appel de l'enregistrement en base */
		newCategory.addProduct(newProduct);
		
		newProduct = productService.addProduct(newProduct);
		Iterable<Product> anyproducts = productService.getProducts();
		anyproducts.forEach(product -> System.out.println(product.getName()));
		
		
		
		
	
	}
	
	
 
}
