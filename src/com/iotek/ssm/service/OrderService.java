package com.iotek.ssm.service;

import com.iotek.ssm.entity.Order;

public interface OrderService {
	Integer findMaxId();
	
	int addOrder(Order order);
}
