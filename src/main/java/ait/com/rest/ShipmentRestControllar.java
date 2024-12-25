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

import ait.com.entity.Shipment;
import ait.com.service.ShipmentService;

@RestController
@RequestMapping("/ait/shipment")
public class ShipmentRestControllar {

	@Autowired
	private ShipmentService shipmentService;

	@PostMapping(value = "/save")
	public ResponseEntity<Shipment> createUser(@RequestBody Shipment shipment) {
		return ResponseEntity.ok(shipmentService.createdShipment(shipment));
	}

	@GetMapping("/all")
	public ResponseEntity<List<Shipment>> getAllShipment() {

		return ResponseEntity.ok(shipmentService.getAllShipment());

	}

	@GetMapping(value = "/edit/{id}")
	public ResponseEntity<Shipment> getShipmentById(@PathVariable("id") Integer id) {

		return shipmentService.getShipmentById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Void> deleteShipment(@PathVariable("id") Integer Id) {

		shipmentService.deleteShipment(Id);

		return ResponseEntity.noContent().build();
	}

	
	@GetMapping(value="/update/{id}")
	
	public ResponseEntity<Shipment> updateShipment(@RequestBody Shipment shipment, @PathVariable("id") Integer Id)
	{
		shipment.setId(Id);
		return ResponseEntity.ok(shipmentService.updateShipment(shipment));
	}
	
	// _____________________________________________________________________________

	// Costam Method

	@GetMapping(value = "/orderid/{OrderId}")
	public ResponseEntity<List<Shipment>> findByOrderId(@PathVariable("OrderId") Long Id) {

		return ResponseEntity.ok(shipmentService.findByOrderId(Id));
		// .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

}
