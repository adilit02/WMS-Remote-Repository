package ait.com.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString(exclude ={"Product"})
@Table(name = "shipments")
public class Shipment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;

	private Long orderId;
	// private String cType;
	private String carrierName;

	private String trackingNumber;

	private String status; // Delivered , IN_Transit

	private LocalDateTime shippedAt; // =LocalDateTime.now();

	// Date Format :- "2024-12-19T15:43:57.0578111"

	@OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL)

	private List<Product> product;

	

}
