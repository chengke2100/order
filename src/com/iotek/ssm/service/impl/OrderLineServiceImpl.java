package com.iotek.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.ssm.dao.OrderLineDao;
import com.iotek.ssm.entity.OrderLine;
import com.iotek.ssm.service.OrderLineService;
@Service("orderLineService")
public class OrderLineServiceImpl implements OrderLineService {
	@Autowired
	private OrderLineDao orderLineDao;
	
	@Override
	public int addOrderLine(OrderLine orderLine) {
		return orderLineDao.insertOrderLine(orderLine);
	}

}
