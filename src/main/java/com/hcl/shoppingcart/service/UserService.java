package com.hcl.shoppingcart.service;

import java.util.Optional;

import com.hcl.shoppingcart.entity.User;

public interface UserService {
	
	Optional<User> findById(Long id);

}
