package ait.com.serviceImpl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ait.com.entity.Product;
import ait.com.repo.OrderRepository;
import ait.com.repo.ProductReoisitory;
import ait.com.repo.ShipmentRepository;
import ait.com.service.ProductService;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private OrderRepository OrderRepo;

	@Autowired
	private ShipmentRepository ShipmentRepo;

	@Autowired
	private ProductReoisitory ProductRepo;

	public Product saveProduct(Product product) {
		return ProductRepo.save(product);

	}

	public Map<Integer, String> getOrderIdAndName() {

		Map<Integer, String> map = new HashMap();

		List<Object[]> list = OrderRepo.getorderIdAndorderType();
		for (Object[] ord : list) {

			int key = Integer.valueOf(ord[0].toString());
			String val = String.valueOf(ord[1]).toString();
			map.put(key, val);
			//map.put(Integer.valueOf(ord[0].toString()), String.valueOf(ord[1]).toString());
		}
		return map;

	}

//---------------------------------------------------
	public Map<Integer, String> getShipmentIdAndCarrierName() {

		Map<Integer, String> map1 = new HashMap();
		List<Object[]> list1 = ShipmentRepo.getShipmentIdAndCarrierName();

		for (Object[] shp : list1) {
			int key = Integer.valueOf(shp[0].toString());
			String val = String.valueOf(shp[1]).toString();
			map1.put(key, val);
		}
		return map1;
	}

}
