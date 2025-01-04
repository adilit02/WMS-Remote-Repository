package ait.com.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ait.com.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Query("select orderId,orderType from Order")// class Variable name And Class Name  
	 List<Object[]> getorderIdAndorderType();
}
