package com.openclassrooms.datalayer.repository;
 
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
import com.openclassrooms.datalayer.model.Product;
 
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	//Integer se rapport au type de l'identifiant de la table Product
	
	public Iterable<Product> findByName(String name);
	
	public Iterable<Product> findByCategoriesName(String name);
	//Categories car l’attribut au sein de l’entité Product se nomme categories ;

	// Requete native
	@Query("FROM Product WHERE name = ?1")
    public Iterable<Product> findByNameJPQL(String name);
	
	// Requete native
	@Query(value = "SELECT * FROM produit WHERE cout = :cout", nativeQuery = true)
	public Iterable<Product> findByCostNative(@Param("cout") Integer cost);
 
	 
}



