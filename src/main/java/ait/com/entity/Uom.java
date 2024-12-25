package ait.com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "uom_table")
public class Uom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uomId;
	private String uomType;
	private double length;
	private double width;
	private double hieght;

}
