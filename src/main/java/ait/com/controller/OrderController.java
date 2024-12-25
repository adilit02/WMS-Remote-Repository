package ait.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ait.com.entity.Order;
import ait.com.service.OrderService;

@Controller

public class OrderController {
	@Autowired
	private OrderService orederService;

	@GetMapping("/ait/order")
	public String OrderMaster(Model model) {
		Order oredr = new Order();

		model.addAttribute("ord", oredr);

		return "OrderMaster";
	}

	@GetMapping("/regorder")
	public String regsterPageLoad(Model model) // Order registration Page Load
	{
		Order order = new Order();

		model.addAttribute("ord", order);

		return "Orderpage";
	}

	@PostMapping("/createorder")
	public String saveOrder(@ModelAttribute("ord") Order order, Model model) {

		boolean save = orederService.saveOrder(order);

		String msg = (save) ? "Order Sucsess....." : "Order Not Sucsess....";

		model.addAttribute("msg", msg);

		return "Orderpage";
	}

	@GetMapping("/orderview")
	public String getAllUser(Model model) {
		List<Order> list = orederService.getAllOrders();

		model.addAttribute("OrderList", list);
		return "OrderView";
	}

	@GetMapping("/orderupdate")
	public String UserUpadte(@RequestParam("orderId") Integer Id, Model model) {

		Order order = orederService.getOrderById(Id);

		model.addAttribute("ord", order);
		return "OrderUpdate";
	}

	@GetMapping("/orderdelete")
	public String deleteUser(@RequestParam("orderId") Integer Id, Model model) {

		orederService.deleteOrder(Id);

		model.addAttribute("OrderList", orederService.getAllOrders());
		// return "redirect:view";
		return "OrderView";
	}

}
