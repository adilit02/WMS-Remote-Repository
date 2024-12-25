//package ait.com.service;

package ait.com.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ait.com.entity.Shipment;
import ait.com.repo.ShipmentRepository;
import ait.com.service.ShipmentService;

@Service
public class ShipmentServiceImp implements ShipmentService {

	@Autowired
	private ShipmentRepository ShipmentRepo;

	@Override
	public List<Shipment> getAllShipment() {

		return ShipmentRepo.findAll();
	}

	@Override
	public Shipment createdShipment(Shipment shipment) {

		return ShipmentRepo.save(shipment);
	}

	@Override
	public Optional<Shipment> getShipmentById(Integer Id) {

		return ShipmentRepo.findById(Id);
	}

	@Override
	public Shipment updateShipment(Shipment shipment) {

		return ShipmentRepo.save(shipment);
	}

	@Override
	public void deleteShipment(Integer Id) {

		ShipmentRepo.deleteById(Id);
	}

	@Override
	public List<Shipment> findByOrderId(Long Id) {

		return ShipmentRepo.findByOrderId(Id);
	}
}
