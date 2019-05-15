package com.hcl.shoppingcart.service;

import java.util.List;
import java.util.Optional;

import com.hcl.shoppingcart.entity.Product;
import com.hcl.shoppingcart.entity.User;

public interface ProductService {

	List<Product> getAllProducts();
	Optional<Product> findByName(String name);
	Optional<Product> findById(Long id);
	Product buyProduct(User user,Long productId);
}
