package ait.com.rest;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ait.com.entity.Order;
import ait.com.service.OrderService;

@RestController
public class OrderRestController {
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/orderAll")
	public ResponseEntity<?> getAllUoms(){
		ResponseEntity<?> response = null;
		
		
		try {
			List<Order> orders = orderService.getAllOrders();
			response = new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response ;
	}
	
	
	@PostMapping("/orderSave")
	public ResponseEntity<String> saveOrder(@RequestBody Order order){
	   ResponseEntity<String> response = null;
	   try{
		   orderService.saveOrder(order);
	    response = new ResponseEntity<String>("Success !", HttpStatus.OK);
	   }
	   catch(Exception e){
	     response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	   }

	   return response;
	}
	
	@GetMapping("/orderEdit/{id}")
	public ResponseEntity<?>  editOrder(@PathVariable("id") Integer id){
	   ResponseEntity<?> response = null;
	   try{
	          Order order = orderService.getOrderById(id);
	          response = new ResponseEntity<Order>(order , HttpStatus.OK);
	   }catch(Exception e){
	          response = new ResponseEntity<String>("Not Exist !", HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	  return response ;
	}
	
	@PutMapping("/orderUpdate/{id}")
	public ResponseEntity<?> updateOrder(@PathVariable("id") Integer id , @RequestBody Order order){
		ResponseEntity<?> response = null;
		
		try {
			Order orderNew = orderService.getOrderById(order.getOrderId()); 
			BeanUtils.copyProperties(order, orderNew);
			orderService.updateOder(orderNew);
			response = new ResponseEntity<>("Updated !", HttpStatus.OK);
			
		} catch (Exception e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
	@DeleteMapping("/orderDelete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") Integer id ){
		ResponseEntity<String> response = null;
		
		try {
			orderService.deleteOrder(id);
			response = new ResponseEntity<>("Deleted !", HttpStatus.OK);
			
		} catch (Exception e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
	
}
