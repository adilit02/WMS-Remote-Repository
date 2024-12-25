package ait.com.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ait.com.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

	// find Inventory Item by Warehouse Id
	Optional findById(Integer warehouseId);

	// find Identity By Sku
	Optional<Inventory> findBySku(String sku);

	// find Inventory Item Below The ReOrder Level
	List<Inventory> findByQuantityLessThanEqual(Integer reOrderLevel);

}
