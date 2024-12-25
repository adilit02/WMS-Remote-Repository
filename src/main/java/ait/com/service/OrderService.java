package ait.com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ait.com.entity.Order;

public interface OrderService {

	public boolean saveOrder(Order order);
	public List<Order> getAllOrders();
	public Order getOrderById(Integer orederId);
	public void updateOder(Order order);
	public void deleteOrder(Integer orderId);
}
