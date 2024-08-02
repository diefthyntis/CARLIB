package com.openclassrooms.datalayer.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "commentaire")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="commentaire_id")
	private int commentId;
	
	@Column(name="contenu")
	private String content;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	/* avec CascadeType.PERSIST, si on supprime le commentaire, le produit ne sera pas supprimé
	 * avec CascadeType.ALL, si on supprime le commentaire, le produit sera supprimé
	 */
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="produit_id")
	private Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}