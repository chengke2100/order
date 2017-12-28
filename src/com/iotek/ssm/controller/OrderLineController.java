package com.iotek.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iotek.ssm.entity.OrderLine;
import com.iotek.ssm.entity.Product;
import com.iotek.ssm.service.OrderLineService;
import com.iotek.ssm.service.ProductService;

@Controller
@RequestMapping("orderLine")
public class OrderLineController {
	@Autowired
	private OrderLineService orderLineService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping("save")
	@ResponseBody
	public String saveOrderLine(Integer oid,Integer productNumber) {
		Product product = productService.findProductById(oid);
		OrderLine orderLine = new OrderLine();
		orderLine.setOid(oid);
		orderLine.setProductName(product.getName());
		orderLine.setProductNumber(productNumber);
		orderLine.setProductPrice(product.getPrice());
		orderLineService.addOrderLine(orderLine);
		return "success";
	}
}
