package ait.com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ait.com.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

	List<OrderItem> findByOrderId(Integer orderId);
	
	List<OrderItem> findByInventoryId(Integer inventoryId);
}
