package com.iotek.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.ssm.dao.OrderDao;
import com.iotek.ssm.entity.Order;
import com.iotek.ssm.service.OrderService;
@Service("OrderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public Integer findMaxId() {
		return orderDao.queryMaxId();
	}

	@Override
	public int addOrder(Order order) {
		return orderDao.insertOrder(order);
	}

}
