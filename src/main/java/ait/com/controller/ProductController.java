package ait.com.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ait.com.entity.Order;
import ait.com.entity.Product;
import ait.com.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService ProdService;

	@GetMapping("/product")
	public String LoadProductPage(Model model) {
		Product prod = new Product();
		model.addAttribute("product", prod);

		Map<Integer, String> map = ProdService.getOrderIdAndName();
		Map<Integer, String> map1 = ProdService.getShipmentIdAndCarrierName();

		model.addAttribute("order", map);
		model.addAttribute("shipment", map1);
		
		//System.out.println(map);
	   //System.out.println(map1);
		return "ProductPage";
	}
	

	@PostMapping("/prodsave")
	public String saveOrder(@ModelAttribute("product") Product product, Model model) {

		Product prodsave = ProdService.saveProduct(product);

		String msg = (prodsave!=null) ? "Product Sucsess....." : "Product Not Sucsess....";

		model.addAttribute("msg", msg);

		return "ProductPage";
	}


}
