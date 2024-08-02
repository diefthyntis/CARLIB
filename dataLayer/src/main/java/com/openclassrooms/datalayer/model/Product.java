package com.openclassrooms.datalayer.model;
 
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "produit")
public class Product {
 
	public Product() {
	    // Constructeur par défaut
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produit_id")
	private int productId;
 
	@Column(name = "nom")
	private String name;
 
	@Column(name = "description")
	private String description;
 
	@Column(name = "cout")
	private int cost;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
 
	/*
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
	@JoinColumn(name = "produit_id")
	List<Comment> comments = new ArrayList<>();
	
	// on désactive le code source ci-dessus car il y a déjà un join colum défini dans la table Comment
	@JoinColumn(name="produit_id")
	fetch = FetchType.EAGER a également été enlevé. Je laisse la valeur par défaut LAZY.
	
	Mais pourquoi ne pas mettre le mappedBy du côté de l’entité Comment ?
	Parce que Spring Data JPA ne le permet pas, 
	c’est forcément le côté @ManyToOne qui doit être maître de la relation et avoir le @JoinColumn, 
	donc le @ManyToOne est implémenté dans la classe Comment
	*/
	@OneToMany(
			mappedBy = "product", 
			cascade = CascadeType.ALL, 
			orphanRemoval = true,
			fetch = FetchType.EAGER
			)
	List<Comment> comments = new ArrayList<>();
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	@ManyToMany(mappedBy = "products",cascade = CascadeType.ALL)
	private List<Category> categories = new ArrayList<>();

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	/* méthodes utilitaires (dites helpers methods, en anglais) */
	public void addComment(Comment comment) {
		comments.add(comment);
		comment.setProduct(this);
	}
 
	public void removeComment(Comment comment) {
		comments.remove(comment);
		comment.setProduct(null);
	}

	
}
