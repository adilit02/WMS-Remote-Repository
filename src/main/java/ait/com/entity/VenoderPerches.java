package ait.com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
//@ToString(exclude = {"user", "shipment"})
@Table(name = "venoder_Dashbord_table")
public class VenoderPerches {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String orderCode;
	private String status;

	@ManyToOne
	@JoinColumn(name = "shipment_fk")
	private Shipment shipment;

	@ManyToOne
	@JoinColumn(name = "user_fk")
	private User user;
	

}
