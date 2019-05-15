package com.hcl.shoppingcart.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.hcl.shoppingcart.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	Optional<Product> findByName(String name);

}
