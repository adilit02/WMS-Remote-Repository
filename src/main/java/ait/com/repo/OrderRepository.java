package ait.com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ait.com.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

	
}
