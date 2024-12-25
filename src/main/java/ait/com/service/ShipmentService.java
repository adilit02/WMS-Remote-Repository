package ait.com.service;

import java.util.List;
import java.util.Optional;

import ait.com.entity.Shipment;

public interface ShipmentService {

	public List<Shipment> getAllShipment();

	public Shipment createdShipment(Shipment shipment);

	public Optional<Shipment> getShipmentById(Integer Id);

	public Shipment updateShipment(Shipment shipment);

	public void deleteShipment(Integer Id);
	
	public List<Shipment> findByOrderId(Long Id);

	

}
