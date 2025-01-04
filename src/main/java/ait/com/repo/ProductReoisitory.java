package ait.com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ait.com.entity.OrderItem;
import ait.com.entity.Product;

public interface ProductReoisitory extends JpaRepository<Product, Integer> {
 
}
