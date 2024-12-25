package ait.com.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ait.com.entity.Warehouse;
import ait.com.service.WarehouseService;

@RestController
@RequestMapping("/ait/warehouse")
public class WarehouseRestControllar {

	@Autowired
	public WarehouseService warehouseService;

	@PostMapping(value = "/save")
	public ResponseEntity<Warehouse> createWarehouse(@RequestBody Warehouse warehouse) {
		return ResponseEntity.ok(warehouseService.createdWarehouse(warehouse));
	}

	@GetMapping(value = "/all")
	public ResponseEntity<List<Warehouse>> getAllWarehouse() {
		return ResponseEntity.ok(warehouseService.getAllWarehouse());
	}

	// TODO  : Write A Code ----> get Warehouse Id
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Warehouse> getUpdateWarehouse(@RequestBody Warehouse warehouse,
			@PathVariable("id") Integer Id) {
		warehouse.setId(Id);
		return ResponseEntity.ok(warehouseService.updateWarehouse(warehouse));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteWarehouse(@PathVariable("id") Integer Id) {
		warehouseService.deleteWarehouse(Id);
		
		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Warehouse> getWarehouseById(@PathVariable("id") Integer Id) {
		return warehouseService.getWarehouseById(Id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

	}

}
