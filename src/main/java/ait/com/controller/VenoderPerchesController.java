package ait.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ait.com.Enum.Status;
import ait.com.entity.PurchesProduct;
import ait.com.entity.VenoderPerches;
import ait.com.service.VenoderPerchesService;

@Controller
//@RequestMapping("/venoder")
public class VenoderPerchesController {
	/*
	 * SCREEN # 1
	 */

	@Autowired
	private VenoderPerchesService venoderperchesService;

	public void uiModule(Model model) {

		model.addAttribute("shipment", venoderperchesService.getShipmentIdAndType());
		model.addAttribute("user", venoderperchesService.getUsertIdAndName());
	}

	@GetMapping("/venoder")
	public String ShowVenoderPerchase(Model model) {
		VenoderPerches vendperchase = new VenoderPerches();

		vendperchase.setStatus(Status.OPEN.name());

		model.addAttribute("vendperchase", vendperchase);

		uiModule(model);

		return "VenoderperchaseRegistraion";
	}

	@PostMapping("/savePerchase")
	public String saveVendorPerchase(@ModelAttribute("vendperchase") VenoderPerches venoderPerches, Model model) {
		Integer saveData = venoderperchesService.saveVendorPerchase(venoderPerches);

		String Result = (saveData != null) ? "Vendore Data Save Sucsess..." : "Vendore Data NOT Save Sucsess...";
		model.addAttribute("msg", Result);

		return "VenoderperchaseRegistraion";
	}

	@GetMapping("/vendorView")
	public String viewVendorData(Model model) {
		List<VenoderPerches> Vnd_list = venoderperchesService.getAllVendorPerchase();

		model.addAttribute("list", Vnd_list);

		return "VenoderperchaseView";
	}

	@GetMapping("/vendordelete")
	public String getDeleteVandor(@RequestParam("vendorId") Integer Id, Model model) {
		venoderperchesService.deleteVenoderPerchase(Id);

		model.addAttribute("list", venoderperchesService.getAllVendorPerchase());

		return "VenoderperchaseView";
	}

	/**
	 * Product Integration
	 */
	public void uiModule2(Model model) {

		model.addAttribute("product", venoderperchesService.getProductIdAndName());

	}

	/**
	 * 
	 * SCREEN # 2
	 * 
	 */
	@GetMapping("/addproduct")
	public String getOrderId(@RequestParam("vendorId") Integer oid, Model model) {
		VenoderPerches OrderId = venoderperchesService.getOneVenoderPerchase(oid);

		/*
		 * VendorPurchase Table Id Wise Row Data Fetch
		 */
		model.addAttribute("vendorPerchaseDtl", OrderId); // All VendorPurchase Id Wise Data

		uiModule2(model); // Fetch Product Id And Name Data
		/*
		 * Dynamik Data Of Product Id And Name Load uiModule2() Method
		 */

		model.addAttribute("purchaeProduct", new PurchesProduct()); // create PurchesProduct Empty Object

		//List<PurchesProduct> allPurchesProduct = venoderperchesService.getAllPurchesProduct(OrderId);
		List<PurchesProduct> allPurchesProduct=venoderperchesService.getAllPurchesProduct(oid);
		model.addAttribute("list", allPurchesProduct); // allPurchesProduct Empty []

		return "PurchaseScreen2";

	}

	@PostMapping("/add")
	public String AddProduct(@ModelAttribute("purchaeProduct") PurchesProduct purchesProduct, Model model) {

		venoderperchesService.savePurchseProduct(purchesProduct);
		Integer oid = purchesProduct.getVendor().getId();// vendor id Opration

		venoderperchesService.changeStatus(oid, Status.PICKING.name()); // vendoer Id Wise Status Change

		return "redirect:addproduct?vendorId=" + oid;
	}

	@GetMapping("/remove")
	public String RemoveProduct(@RequestParam("pid") Integer pid, @RequestParam("oid") Integer oid, Model model) {

		/*
		 * Purchase Product Id Wise Row Data Delete
		 */
		
		venoderperchesService.RemovePurchesProductProuct(pid);

		/*
		 * All Product Purchase Table List Data [] Empty So Change Status
		 */
		if(venoderperchesService.getProductCountByOrderId(oid)==0)
		{
			venoderperchesService.changeStatus(oid, Status.OPEN.name());
		}
		
		return "redirect:addproduct?vendorId=" + oid;
	}
	
	/*
	 * Order Now
	 */

	@GetMapping("/placeOrder")
	public String placeOrder(@RequestParam("oid")Integer oid,Model model )
	{
		venoderperchesService.changeStatus(oid, Status.ORDERED.name());
		
		return "redirect:addproduct?vendorId=" + oid;
	}
	
	
}
