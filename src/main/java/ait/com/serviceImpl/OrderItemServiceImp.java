//package ait.com.service;

package ait.com.serviceImpl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ait.com.entity.OrderItem;
import ait.com.repo.OrderItemRepository;
import ait.com.service.OrderItemService;

@Service
public class OrderItemServiceImp implements OrderItemService {

	@Autowired
	private OrderItemRepository OrderItemRepo;

	@Override
	public List<OrderItem> getAllOrderItem() {

		return OrderItemRepo.findAll();
	}

	@Override
	public OrderItem createdOrderItem(OrderItem orderItem) {

		return OrderItemRepo.save(orderItem);
	}

	@Override
	public Optional<OrderItem> getOrderItemById(Integer Id) {

		return OrderItemRepo.findById(Id);
	}

	@Override
	public OrderItem updateOrderItem(OrderItem orderItem) {

		return OrderItemRepo.save(orderItem);
	}

	@Override
	public void deleteOrderItem(Integer Id) {

		OrderItemRepo.deleteById(Id);
	}

	@Override
	public List<OrderItem> findByOrderId(Integer Id) {
		
		return OrderItemRepo.findByOrderId(Id);
	}

	@Override
	public List<OrderItem> findByInventoryId(Integer inventoryId) {
	
		return OrderItemRepo.findByInventoryId(inventoryId);
	}

}
