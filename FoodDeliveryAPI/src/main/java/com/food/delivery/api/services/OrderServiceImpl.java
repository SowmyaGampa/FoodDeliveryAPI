package com.food.delivery.api.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.food.delivery.api.model.Item;
import com.food.delivery.api.model.Order;
import com.food.delivery.api.model.OrderStatus;
import com.food.delivery.api.model.OrderStatusUpdateMessage;
import com.food.delivery.api.repository.OrderRepository;


@Service
public class OrderServiceImpl implements OrderService{
	
	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order placeOrder(Order order) {
		logger.info("----placeOrder ServiceImpl method -----");
		LocalDate ldObj = LocalDate.now();
		order.setCreationTime(ldObj);
		order.setLastModifyTime(ldObj);
		
		return orderRepository.save(order);
	}

	@Override
	public Order findOrderId(int orderId) {
		logger.info("----findOrderId ServiceImpl method -----");
		return orderRepository.findById(orderId);
	}
	

	@Override
	public void updateOrderStatus(int orderId, OrderStatusUpdateMessage orderStatusUpdateMessage) {
		logger.info("----findOrderId ServiceImpl method -----");
		
		Order order =orderRepository.findById(orderId);
		System.out.println("order : : " +order.toString()); 
		String newStatus = orderStatusUpdateMessage.getOrderStatus();
		order.setOrderStatus(newStatus);

		LocalDate ldObj = LocalDate.now();
        order.setLastModifyTime(ldObj);
        orderRepository.save(order);
	}

	@Override
	public List<Order> findByUserId(String userId) {
		logger.info("----findByUserId ServiceImpl method -----");
		//List<Order> response=
		return orderRepository.findByUserId(userId);
	}

	
	public double calculateTotalCost(List<Item> items) {
        double cost = 0L;
        for(Item item : items) {
            cost += item.getPrice()*100;
        }
        return cost/100.0;
    }

}
