package ait.com.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="purches_product")
public class PurchesProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(name="product_fk")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="vendor_perchase_fk")
	private VenoderPerches vendor;
}
