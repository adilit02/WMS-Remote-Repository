package ait.com.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ait.com.entity.Order;
import ait.com.exception.OrderNotFoundException;
import ait.com.repo.OrderRepository;
import ait.com.service.OrderService;
@Service

public class OrderServiceImpl implements OrderService{
	
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public boolean saveOrder(Order order) {
		
		return orderRepository.save(order).getOrderId()!=null;
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Order getOrderById(Integer orederId) {
		Order order = null;
		Optional<Order> optional = orderRepository.findById(orederId);
		if(optional.isPresent()) {
			order = optional.get();
			return order;
		}else {
			throw new OrderNotFoundException("Order does not exist !");
		}
	}

	@Override
	public void updateOder(Order order) {
		orderRepository.save(order);
		
	}

	@Override
	public void deleteOrder(Integer orderId) {
		orderRepository.deleteById(orderId);
	}

	

}
