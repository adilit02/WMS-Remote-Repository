package ait.com.service;

import java.util.List;
import java.util.Optional;

import ait.com.entity.OrderItem;

public interface OrderItemService {

	public OrderItem createdOrderItem(OrderItem orderItem);

	public List<OrderItem> getAllOrderItem();

	public Optional<OrderItem> getOrderItemById(Integer Id);

	public OrderItem updateOrderItem(OrderItem orderItem);

	public void deleteOrderItem(Integer Id);

	public List<OrderItem> findByOrderId(Integer Id);

	List<OrderItem> findByInventoryId(Integer inventoryId);

}
