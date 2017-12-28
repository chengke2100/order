package com.iotek.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.ssm.dao.CustomerDao;
import com.iotek.ssm.service.CustomerService;
@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;

	@Override
	public Integer verifyCustomer(String cname) {
		return customerDao.verifyCustomer(cname);
	}

}
