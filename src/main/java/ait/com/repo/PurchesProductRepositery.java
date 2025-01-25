package ait.com.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ait.com.entity.PurchesProduct;

public interface PurchesProductRepositery extends JpaRepository<PurchesProduct, Integer> {

	@Query("select pp from PurchesProduct pp join pp.vendor as vp where vp.id=:orderId")
	public List<PurchesProduct> getAllPurchaseProductById(@Param("orderId")  Integer orderId);
	
	
	@Query("select count(pp.id) from  PurchesProduct pp join pp.vendor as vp where vp.id=:orderId") 
	public Integer getProductCountByOrderId(@Param("orderId") Integer orderId);
	
}
