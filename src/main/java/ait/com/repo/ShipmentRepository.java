package ait.com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ait.com.entity.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {

	List<Shipment> findByOrderId(Long Id);
}
