package ait.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ait.com.entity.Order;
import ait.com.entity.Shipment;
import ait.com.service.ShipmentService;

@Controller
public class ShipmentController {

	@Autowired
	private ShipmentService shipService;
	
	@GetMapping("/shipmentorder")
	public String OrderMaster(Model model) {
		Shipment shipment = new Shipment();

		model.addAttribute("ship", shipment);

		return "ShipmentPage";
	}
	
	@PostMapping("/createshipment")
	public String saveShipment(@ModelAttribute("ship") Shipment shipment, Model model) {

		Shipment save = shipService.createdShipment(shipment);

		String msg = (save!=null) ? "Shipment Sucsess....." : "Shipment Not Sucsess....";

		model.addAttribute("msg", msg);

		return "ShipmentPage";
	}
	
	@GetMapping("/shipmentview")
	public String getAllShipment( @ModelAttribute("ship") Shipment shipment,Model model)
	{
		List<Shipment> list=shipService.getAllShipment();
		
		model.addAttribute("shiptlist", list);
		
		return "ShipmentView";
	}

	//____________________Update And Delete Url Painding_________________________
	
}
