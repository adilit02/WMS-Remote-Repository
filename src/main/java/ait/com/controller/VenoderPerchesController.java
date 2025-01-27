package ait.com.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

import ait.com.Enum.Status;
import ait.com.entity.PurchesProduct;
import ait.com.entity.VenoderPerches;
import ait.com.service.VenoderPerchesService;
import jakarta.servlet.http.HttpServletResponse;

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

	/*
	 * PDF Genrate
	 */

	@GetMapping("/pdfGenrate")
	public String PdfGenrateFile(@RequestParam("vendorId") Integer oid, Model model, HttpServletResponse response)
			throws IOException {

		VenoderPerches OrderId = venoderperchesService.getOneVenoderPerchase(oid);

		List<PurchesProduct> all = venoderperchesService.getAllPurchesProduct(oid);

		response.setContentType("application/pdf");
		// response.setHeader("Content-Disposition", " attachment;
		// filename=Purchase-Bill.pdf");

		Document document = new Document(new PdfDocument(new PdfWriter(response.getOutputStream())));
		document.add(new Paragraph("PURCHASE BILL").setFontColor(ColorConstants.BLUE).setBold()
				.setTextAlignment(TextAlignment.CENTER).setFontSize(20).setUnderline(1.5f, -1.5f));
		document.add(new Paragraph("\n"));
		document.add(new Paragraph("Date: " + LocalDate.now().toString()).setTextAlignment(TextAlignment.RIGHT)
				.setFontSize(12));
		document.add(new Paragraph("\n"));

		float[] columnWidths = { 20F, 200F, 150F, 70F, 50F, 70F, 100F, 90F, 100F };// { 1, 3, 3, 3, 2,3 };

		Table table = new Table(columnWidths);

		document.add(new Paragraph("SHOP NAME : WAREHOUSE").setBold().setTextAlignment(TextAlignment.LEFT)
				.setFontSize(12).setFontColor(ColorConstants.GREEN));
		document.add(new Paragraph("\n"));

		table.setWidth(UnitValue.createPercentValue(100));

		table.addHeaderCell(new Cell().add(new Paragraph("ID").setBold()));
		table.addHeaderCell(new Cell().add(new Paragraph("Vendor Name").setBold()));
		table.addHeaderCell(new Cell().add(new Paragraph("Product").setBold()));
		table.addHeaderCell(new Cell().add(new Paragraph("Status").setBold()));
		table.addHeaderCell(new Cell().add(new Paragraph("Quntity").setBold()));
		table.addHeaderCell(new Cell().add(new Paragraph("Price").setBold()));
		table.addHeaderCell(new Cell().add(new Paragraph("Total").setBold()));
		table.addHeaderCell(new Cell().add(new Paragraph("Total Bill").setBold()));
		table.addHeaderCell(new Cell().add(new Paragraph("GST").setBold()));

		table.addCell(new Cell().add(new Paragraph(String.valueOf(OrderId.getId()))));
		table.addCell(new Cell().add(new Paragraph(OrderId.getUser().getName())));
		table.addCell(new Cell().add(
				new Paragraph(all.stream().map(p -> p.getProduct().getPname()).collect(Collectors.joining(", ")))));

		table.addCell(new Cell().add(new Paragraph(OrderId.getStatus())));

		table.addCell(new Cell().add(new Paragraph(
				all.stream().map(p -> String.valueOf(p.getQuantity())).collect(Collectors.joining(", ")))));

		table.addCell(new Cell().add(new Paragraph(
				all.stream().map(p -> String.valueOf(p.getProduct().getPrice())).collect(Collectors.joining(", ")))));

		table.addCell(new Cell().add(new Paragraph(all.stream().map(p -> String.valueOf(p.getProduct().getTotalPrice()))
				.collect(Collectors.joining(", ")))));

		table.addCell(new Cell().add(new Paragraph(all.stream()
				.map(p -> String.valueOf(p.getProduct().getTotalPriceWithGST())).collect(Collectors.joining(", ")))));

		table.addCell(new Cell()
				.add(new Paragraph(all.stream().map(p -> String.valueOf("18 %")).collect(Collectors.joining(", ")))));

		// table.addCell(new Cell().add(new Paragraph(String.format("----"))));

		document.add(table);

		document.add(new Paragraph("\n"));
		document.add(new Paragraph("Thank you for your purchase!").setFontColor(ColorConstants.DARK_GRAY)
				.setTextAlignment(TextAlignment.CENTER).setFontSize(14).setBold());
		document.add(new Paragraph("We appreciate your business and look forward to serving you again.")
				.setTextAlignment(TextAlignment.CENTER).setFontSize(12));

		document.close();

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

		uiModule2(model); // Product Id And Name Data
		/*
		 * Dynamik Data Of Product Id And Name Load uiModule2() Method
		 */

		model.addAttribute("purchaeProduct", new PurchesProduct()); // create PurchesProduct Empty Object

		List<PurchesProduct> allPurchesProduct = venoderperchesService.getAllPurchesProduct(oid);

		model.addAttribute("list", allPurchesProduct); // allPurchesProduct Empty []

		return "PurchaseScreen2";

	}

	@PostMapping("/add")
	public String AddProduct(@ModelAttribute("purchaeProduct") PurchesProduct purchesProduct, Model model) {

		double prod_price = purchesProduct.getProduct().getPrice();

		Integer Quntity = purchesProduct.getQuantity();
		purchesProduct.getProduct().setTotalPrice(prod_price * Quntity);

		int gstRate = 18;
		// Calculate the GST amount
		double gstAmount = (prod_price * Quntity * gstRate) / 100;

		// Calculate the total price with GST
		double totalPriceWithGST = prod_price * Quntity + gstAmount;

		purchesProduct.getProduct().setTotalPriceWithGST(totalPriceWithGST);

		// purchesProduct.getProduct().setGstRate(gstRate);
		// System.out.println("----------> " + prod_price + " " + (prod_price *
		// Quntity));

		// System.out.println("----------> " + totalPriceWithGST + " " + gstAmount);

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
		if (venoderperchesService.getProductCountByOrderId(oid) == 0) {
			venoderperchesService.changeStatus(oid, Status.OPEN.name());
		}

		return "redirect:addproduct?vendorId=" + oid;
	}

	/*
	 * Order Now
	 */

	@GetMapping("/placeOrder")
	public String placeOrder(@RequestParam("oid") Integer oid, Model model) {
		venoderperchesService.changeStatus(oid, Status.ORDERED.name());

		return "redirect:addproduct?vendorId=" + oid;
	}

}
