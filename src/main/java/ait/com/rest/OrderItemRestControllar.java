package ait.com.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ait.com.entity.OrderItem;
import ait.com.service.OrderItemService;

@RestController
@RequestMapping("/ait/orderItem")
public class OrderItemRestControllar {

	@Autowired
	private OrderItemService orderItemService;

	@PostMapping(value = "/save")
	public ResponseEntity<OrderItem> createdOrderItem(@RequestBody OrderItem orderItem) {

		return ResponseEntity.ok(orderItemService.createdOrderItem(orderItem));
	}

	@GetMapping(value = "/all")
	public ResponseEntity<List<OrderItem>> getAllOrderItem() {
		return ResponseEntity.ok(orderItemService.getAllOrderItem());

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<OrderItem> getOrderItemById(@PathVariable("id") Integer Id) {

		return orderItemService.getOrderItemById(Id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<OrderItem> updateOrderItem(@RequestBody OrderItem orderItem, @PathVariable("id") Integer Id) {
		orderItem.setId(Id);

		return ResponseEntity.ok(orderItemService.updateOrderItem(orderItem));
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Void> deleteOrderItem(@PathVariable("id") Integer Id) {
		orderItemService.deleteOrderItem(Id);
		return ResponseEntity.noContent().build();
	}

	// ------------------------------------------------------------------------
	                 // Custam Method

	@GetMapping(value = "/orderid/{id}")
	public ResponseEntity<List<OrderItem>> findByOrderId(@PathVariable("id") Integer Id) {

		return ResponseEntity.ok(orderItemService.findByOrderId(Id));

		// return orderItemService.findByOrderId(Id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping(value = "/inventoryid/{id}")
	public ResponseEntity<List<OrderItem>> findByInventoryId(@PathVariable("id") Integer Id) {

		return ResponseEntity.ok(orderItemService.findByInventoryId(Id));
	}
}
