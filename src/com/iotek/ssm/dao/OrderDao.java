package com.iotek.ssm.dao;

import com.iotek.ssm.entity.Order;

public interface OrderDao {
	Integer queryMaxId();
	
	int insertOrder(Order order);
}
