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
import jakarta.persistence.Table;

@Entity
@Table(name = "categorie")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="categorie_id")
	private int categoryId;
	
	@Column(name="nom")
	private String name;
	
	
	//FetchType.LAZY empêche de compiler
	@ManyToMany(
			fetch = FetchType.EAGER,
			cascade = { 
					CascadeType.ALL, 
					CascadeType.MERGE 
					}	
			)
	@JoinTable(
			name = "categorie_produit",
			joinColumns = @JoinColumn(name = "categorie_id"), 
			inverseJoinColumns = @JoinColumn(name = "produit_id")
			)
	private List<Product> products = new ArrayList<>();	

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return "Categorie " + name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	/* méthodes utilitaires (dites helpers methods, en anglais) 
	Pour une relation bidirectionnelle OneToMany/ManyToOne : elles seront du côté OneToMany,
	là où on gère une liste d’éléments.
	Pour une relation bidirectionnelle ManyToMany : elles seront bien souvent du côté de l’entité 
	qui gère la relation, celle où il y a le @JoinTable.
	
	*/
	public void addProduct(Product product) {
		products.add(product);
		product.getCategories().add(this);
	}
 
	public void removeProduct(Product product) {
		products.remove(product);
		product.getCategories().remove(this);
	}

	
}