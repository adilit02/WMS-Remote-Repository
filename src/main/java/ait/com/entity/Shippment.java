package ait.com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name="Shippment_Table")
@ToString
public class Shippment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sId;
	private String sType;
	private Double sCode;

	public Integer getsId() {
		return sId;
	}

	@Override
	public String toString() {
		return "Shippment [sId=" + sId + ", sType=" + sType + ", sCode=" + sCode + "]";
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getsType() {
		return sType;
	}

	public void setsType(String sType) {
		this.sType = sType;
	}

	public Double getsCode() {
		return sCode;
	}

	public void setsCode(Double sCode) {
		this.sCode = sCode;
	}

}
