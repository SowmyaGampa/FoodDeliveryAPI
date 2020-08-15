package com.food.delivery.api.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.food.delivery.api.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	Order findById(int orderId);

	@Query("select o from Order o where o.userid=:userId")
	List<Order> findByUserId(String userId);
	
	
	
	

}
