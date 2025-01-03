package ait.com.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "inventory")
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;
	private Integer warehouseId;
	private String itemName;
	private String sku; // Stock Keeping Unit
	private Integer quantity;
	private Double price;
	private Integer reOrderLevel;
	private LocalDateTime updatedAt = LocalDateTime.now();
	
	@ManyToOne(cascade = CascadeType.ALL)
	private OrderItem orderitem;
	
}
