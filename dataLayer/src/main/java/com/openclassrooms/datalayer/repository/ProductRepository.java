package com.openclassrooms.datalayer.repository;
 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
import com.openclassrooms.datalayer.model.Product;
 
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	//Integer se rapport au type de l'identifiant de la table Product
}
