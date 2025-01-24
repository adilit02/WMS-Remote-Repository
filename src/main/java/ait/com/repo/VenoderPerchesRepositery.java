package ait.com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ait.com.entity.VenoderPerches;

public interface VenoderPerchesRepositery extends JpaRepository<VenoderPerches, Integer> {
	
	/*
	 @Modifying
	 @Query("update VenoderPerches set status=: pstatus where id=:oid") // Not Working 
	                                                                    // Show Error 
	 public void updateStatusById(Integer oid,String pstatus);
*/
	
	
	@Modifying
	@Query("update VenoderPerches set status = :pstatus where id = :oid")
	public void updateStatusById(@Param("oid") Integer oid, @Param("pstatus") String pstatus);
	
	
}
