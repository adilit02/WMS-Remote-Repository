package ait.com.service;

import java.util.List;
import java.util.Map;

import ait.com.entity.PurchesProduct;
import ait.com.entity.VenoderPerches;

public interface VenoderPerchesService {

	/*
	 * Screen # 1
	 */
	public Integer saveVendorPerchase(VenoderPerches venoderperchase);

	public List<VenoderPerches> getAllVendorPerchase();

	public VenoderPerches getOneVenoderPerchase(Integer id);

	public void updateVenoderPerchase(VenoderPerches venoderperchase);

	public void deleteVenoderPerchase(Integer id);

	/*
	 * Integration Method
	 */

	Map<Integer, String> getShipmentIdAndType();

	Map<Integer, String> getUsertIdAndName();
	
	Map<Integer, String> getProductIdAndName();

	/*
	 * Screen # 2
	 */
	
	public Integer savePurchseProduct(PurchesProduct purchesProduct);
	public List<PurchesProduct> getAllPurchesProduct();
	public void RemovePurchesProductProuct(Integer id);
	
	/*
	 * Update Status 
	 */
	
	public void changeStatus(Integer oid,String pstatus);
}
