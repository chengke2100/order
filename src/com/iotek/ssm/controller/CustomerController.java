package com.iotek.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iotek.ssm.service.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@ResponseBody
	@RequestMapping("verify")
	public String verifyCustomer(String cname) {
		Integer cid = customerService.verifyCustomer(cname);
		if(cid==null) {
			return "¿Í»§Ãû³Æ´íÎó";
		}
		return "true";
	}
}
