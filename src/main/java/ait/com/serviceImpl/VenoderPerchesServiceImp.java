package ait.com.serviceImpl;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ait.com.entity.PurchesProduct;
import ait.com.entity.VenoderPerches;
import ait.com.exception.VenoderPerchesNotFoundException;
import ait.com.repo.ProductRpositery;
import ait.com.repo.PurchesProductRepositery;
import ait.com.repo.ShipmentRepository;
import ait.com.repo.UserRepository;
import ait.com.repo.VenoderPerchesRepositery;
import ait.com.service.VenoderPerchesService;

@Service
public class VenoderPerchesServiceImp implements VenoderPerchesService {

	@Autowired
	private VenoderPerchesRepositery VenoderPerchaseRepo;

	@Autowired
	private ShipmentRepository shipmentRepo;

	@Autowired
	private UserRepository UserRepo;

	@Autowired
	private ProductRpositery ProductRepo;

	@Autowired
	private PurchesProductRepositery PurchesProductRepo;

	@Override
	public Integer saveVendorPerchase(VenoderPerches venoderperchase) {

		return VenoderPerchaseRepo.save(venoderperchase).getId();
	}

	@Override
	public List<VenoderPerches> getAllVendorPerchase() {

		return VenoderPerchaseRepo.findAll();
	}

	@Override
	public VenoderPerches getOneVenoderPerchase(Integer id) {
		VenoderPerches venoderperchase = VenoderPerchaseRepo.findById(id)
				.orElseThrow(() -> new VenoderPerchesNotFoundException("VenoderPerchase Not Found............"));
		return venoderperchase;
	}

	@Override
	public void updateVenoderPerchase(VenoderPerches venoderperchase) {
		VenoderPerchaseRepo.save(venoderperchase);

	}

	@Override
	public void deleteVenoderPerchase(Integer id) {

		VenoderPerchaseRepo.deleteById(id);

	}

	@Override
	public Map<Integer, String> getShipmentIdAndType() {

		List<Object[]> shipIdAndName = shipmentRepo.getShipmentIdAndCarrierName();

		Map<Integer, String> map = new HashMap();

		for (Object[] obj : shipIdAndName) {

			map.put(Integer.valueOf(obj[0].toString()), String.valueOf(obj[1]).toString());
		}
		return map;
	}

	@Override
	public Map<Integer, String> getUsertIdAndName() {

		List<Object[]> userIdAndName = UserRepo.getUserIdAndname();

		Map<Integer, String> map = new HashMap();

		for (Object[] obj : userIdAndName) {

			map.put(Integer.valueOf(obj[0].toString()), String.valueOf(obj[1]).toString());
		}
		return map;
	}

	@Override
	public Map<Integer, String> getProductIdAndName() {

		List<Object[]> ProductIdAndName = ProductRepo.getProductIdAndProductName();

		Map<Integer, String> map = new HashMap();

		for (Object[] obj : ProductIdAndName) {

			map.put(Integer.valueOf(obj[0].toString()), String.valueOf(obj[1]).toString());
		}
		return map;
	}

	/**
	 * Screen # 2
	 */

	@Override
	public Integer savePurchseProduct(PurchesProduct purchesProduct) {

		return PurchesProductRepo.save(purchesProduct).getId();
	}

	@Override
	public List<PurchesProduct> getAllPurchesProduct() {
		return PurchesProductRepo.findAll();
	}

	@Override
	public void RemovePurchesProductProuct(Integer id) {
		PurchesProductRepo.deleteById(id);

	}

	@Transactional
	@Override
	public void changeStatus(Integer oid, String pstatus) {

		VenoderPerchaseRepo.updateStatusById(oid, pstatus);
	}

}
