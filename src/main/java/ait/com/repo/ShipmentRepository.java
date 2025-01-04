package ait.com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ait.com.entity.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {

	List<Shipment> findByOrderId(Long Id);
	

	@Query("select id,carrierName from Shipment")// class Variable name And Class Name  
	 List<Object[]> getShipmentIdAndCarrierName();
}
