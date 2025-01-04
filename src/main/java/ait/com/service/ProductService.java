package ait.com.service;

import java.util.Map;

import ait.com.entity.Product;

public interface ProductService {

	Map<Integer, String> getOrderIdAndName();

	Map<Integer, String> getShipmentIdAndCarrierName();

	Product saveProduct(Product product);
}
