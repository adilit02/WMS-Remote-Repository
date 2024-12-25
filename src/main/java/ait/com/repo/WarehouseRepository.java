package ait.com.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ait.com.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {

	List<Warehouse> findByLocation(String location);
	
	List<Warehouse> findByCapacityGreaterThanEqual(Integer capacity);
	                              // define Adil Sir Capacity String
	
   // List<Warehouse> findByCapacityGreaterThanEqual(String capacity);
}
