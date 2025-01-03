package ait.com.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "order_items")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	
	private Long orderId;
	
	private Long inventoryId;
	
	private Integer quantity;
	
	private Double price;

	@OneToMany(mappedBy = "orderitem",cascade =CascadeType.ALL )
	private List<Order> order;
	
	
	@OneToMany(mappedBy = "orderitem",cascade =CascadeType.ALL )
	 private List<Inventory> inventory;
}
