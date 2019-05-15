package com.hcl.shoppingcart.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.shoppingcart.entity.User;
import com.hcl.shoppingcart.repository.ProductRepository;
import com.hcl.shoppingcart.repository.UserRepository;
import com.hcl.shoppingcart.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	ProductRepository productRepository;
	@Autowired
	UserRepository userRepository;
	@Override
	public Optional<User> findById(Long id) {
		
		return userRepository.findById(id);
	}
	
	
}
