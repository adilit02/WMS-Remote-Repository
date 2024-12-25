package ait.com.service;

import java.util.List;
import java.util.Optional;

import ait.com.entity.Warehouse;

public interface WarehouseService {

	public List<Warehouse> getAllWarehouse();

	public Warehouse createdWarehouse(Warehouse warehouse);

	public Optional<Warehouse> getWarehouseById(Integer Id);

	public Warehouse updateWarehouse(Warehouse warehouse);

	public void deleteWarehouse(Integer Id);

}
