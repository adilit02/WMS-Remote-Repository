//package ait.com.service;

package ait.com.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ait.com.entity.Warehouse;
import ait.com.repo.WarehouseRepository;
import ait.com.service.WarehouseService;

@Service
public class WarehouseServiceImp implements WarehouseService {

	@Autowired
	private WarehouseRepository WarehouseRepo;

	@Override
	public List<Warehouse> getAllWarehouse() {

		return WarehouseRepo.findAll();
	}

	@Override
	public Warehouse createdWarehouse(Warehouse warehouse) {

		return WarehouseRepo.save(warehouse);
	}

	@Override
	public Optional<Warehouse> getWarehouseById(Integer Id) {

		return WarehouseRepo.findById(Id);

	}

	@Override
	public Warehouse updateWarehouse(Warehouse warehouse) {

		return WarehouseRepo.save(warehouse);
	}

	@Override
	public void deleteWarehouse(Integer Id) {

		WarehouseRepo.deleteById(Id);

	}

}
