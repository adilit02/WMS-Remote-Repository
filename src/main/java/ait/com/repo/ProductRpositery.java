package ait.com.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ait.com.entity.Product;

public interface ProductRpositery extends JpaRepository<Product, Integer> {
 
	@Query("select pid,pname from Product")
	List<Object[]> getProductIdAndProductName();
}
