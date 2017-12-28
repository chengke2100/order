package com.iotek.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.ssm.dao.ProductDao;
import com.iotek.ssm.entity.Product;
import com.iotek.ssm.service.ProductService;
@Service("productService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;
	@Override
	public List<Product> findAllProducts() {
		return productDao.queryAllProducts();
	}
	@Override
	public Product findProductById(Integer pid) {
		return productDao.queryProductById(pid);
	}

}
