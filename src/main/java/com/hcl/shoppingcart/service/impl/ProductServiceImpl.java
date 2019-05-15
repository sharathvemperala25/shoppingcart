package com.hcl.shoppingcart.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hcl.shoppingcart.entity.Product;
import com.hcl.shoppingcart.entity.User;
import com.hcl.shoppingcart.repository.ProductRepository;
import com.hcl.shoppingcart.repository.UserRepository;
import com.hcl.shoppingcart.service.ProductService;
import com.hcl.shoppingcart.service.UserService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	UserRepository userRepository;
	@Override
	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}
	
	@Override
	public Product buyProduct(User user, Long productId) {
		Optional<Product> Optionalproduct = productRepository.findById(productId);
		  Product product = Optionalproduct.get();
		  product.setOwner(user);
		  
			return productRepository.save(product); 
	}

	@Override
	public Optional<Product> findByName(String name) {
		// TODO Auto-generated method stub
		return productRepository.findByName(name);
	}

	@Override
	public Optional<Product> findById(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}
}
