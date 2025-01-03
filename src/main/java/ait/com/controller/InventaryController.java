package ait.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InventaryController {

	@GetMapping("/")
	public String InventoryData(Model model)
	{
		return "home";
		
	}
}
