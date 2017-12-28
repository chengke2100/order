package com.iotek.ssm.dao;

import java.util.List;

import com.iotek.ssm.entity.Product;

public interface ProductDao {
	List<Product> queryAllProducts();

	Product queryProductById(Integer pid);

}
