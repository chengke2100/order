package com.iotek.ssm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iotek.ssm.entity.Order;
import com.iotek.ssm.entity.Product;
import com.iotek.ssm.service.CustomerService;
import com.iotek.ssm.service.OrderService;
import com.iotek.ssm.service.ProductService;

@Controller
@RequestMapping("order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping("add")
	public String add(Model model) {
		Integer maxId = orderService.findMaxId();
		if(maxId==null) {
			maxId=0;
		}
		int id = maxId+1;
		Date orderDate = new Date();
		model.addAttribute("id", id);
		model.addAttribute("orderDate", orderDate);
		return "add";
	}
	
	@RequestMapping("addOrder")
	public String addOrder(Order order,String orderDate1,String deliverDate1,Model model) {
		Integer cid = customerService.verifyCustomer(order.getCname());
		System.out.println(order.getAddress());
		order.setCid(cid);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date orderDate=null;
		Date deliverDate=null;
		try {
			orderDate = sdf.parse(orderDate1);
			deliverDate = sdf.parse(deliverDate1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		order.setOrderDate(orderDate);
		order.setDeliverDate(deliverDate);
		order.setStatus("Î´ËÍ´ï");
		orderService.addOrder(order);
		model.addAttribute("order", order);
		model.addAttribute("id", order.getId());
		model.addAttribute("orderDate", orderDate);
		List<Product> products = productService.findAllProducts();
		model.addAttribute("products", products);
		return "add";
	}
	
	@ResponseBody
	@RequestMapping("detail")
	public String detail(Integer pid,Model model) {
		Product product = productService.findProductById(pid);
		String data = ""+product.getPrice();
		return data;
	}
}
