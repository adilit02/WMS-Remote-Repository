package ait.com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ait.com.entity.OrderItem;
import ait.com.service.OrderItemService;

@Controller
public class OrderItemController {

	@Autowired
	private OrderItemService orderItemService;

	@GetMapping("/ait/orderitem")
	public String save(Model model) {

		OrderItem orderItem = new OrderItem();

		model.addAttribute("ordItem", orderItem);

		return "OrderItemPage";
	}

	@PostMapping("/createorderItem")
	public String saveOrderItem(@ModelAttribute("ordItem") OrderItem orderItem, Model model) {

		OrderItem save = orderItemService.createdOrderItem(orderItem);

		String msg = (save != null) ? "OrderItem Sucsess....." : "OrderItem Not Sucsess....";

		model.addAttribute("msg", msg);

		return "OrderItemPage";
	}

	@GetMapping("/orderItemview")
	public String getAllOrderItem(Model model) {
		List<OrderItem> list = orderItemService.getAllOrderItem();

		// System.out.println(list);

		model.addAttribute("OrderItemList", list);
		return "OrderItemView";
	}

	@GetMapping("/orderItemupdate")
	public String OrderItemUpadte(@RequestParam("orderItemId") Integer Id, Model model) {

		Optional<OrderItem> orderItem = orderItemService.getOrderItemById(Id);

		model.addAttribute("ordItem", orderItem);

		return "OrderItemUpdate";

	}

	@GetMapping("/orderItemudelete")
	public String OrderItemDelete(@RequestParam("orderItemId") Integer Id, Model model) {

		orderItemService.deleteOrderItem(Id);

		model.addAttribute("OrderItemList", orderItemService.getAllOrderItem()); // return
		return "OrderItemView";
	}

	// -----------------------------------------------------------------------

	/*
	 * 
	 * 
	 * public List<OrderItem> findByOrderId(Integer Id);
	 * 
	 * List<OrderItem> findByInventoryId(Integer inventoryId);
	 * 
	 * 
	 */
}
