package com.food.delivery.api.services;

import java.util.List;

import com.food.delivery.api.model.Order;
import com.food.delivery.api.model.OrderStatusUpdateMessage;

public interface OrderService {
	
    Order placeOrder(Order order);
	
	Order findOrderId(int orderId);

	List<Order> findByUserId(String userId);
	
    void updateOrderStatus(int orderId, OrderStatusUpdateMessage orderStatusUpdateMessage);


}
