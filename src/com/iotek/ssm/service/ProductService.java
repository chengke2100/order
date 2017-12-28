package com.iotek.ssm.service;

import java.util.List;

import com.iotek.ssm.entity.Product;

public interface ProductService {
	List<Product> findAllProducts();

	Product findProductById(Integer pid);

}
