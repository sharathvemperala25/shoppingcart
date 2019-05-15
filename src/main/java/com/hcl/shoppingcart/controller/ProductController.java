package com.hcl.shoppingcart.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.shoppingcart.entity.Product;
import com.hcl.shoppingcart.entity.User;
import com.hcl.shoppingcart.service.ProductService;
import com.hcl.shoppingcart.service.UserService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/listOfAllProducts")
	public ResponseEntity listOfProducts(){
		List<Product> listOfProducts = productService.getAllProducts();
		if(listOfProducts.isEmpty()) {
			return new ResponseEntity("No product Found",HttpStatus.NO_CONTENT);
		}
	
		return new ResponseEntity(listOfProducts,HttpStatus.OK);
	}
	
	@GetMapping("/products/{productName}")
	public ResponseEntity searchProductByName(@PathVariable String productName) {
		Optional<Product> returnedproduct = productService.findByName(productName);
		System.out.println(returnedproduct);
		if(returnedproduct.isPresent()) {
			return new ResponseEntity(returnedproduct.get(),HttpStatus.OK);
		}
		return new ResponseEntity("The product is not available",HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/buyProduct")
	public ResponseEntity buyproduct(@RequestParam Long userId,@RequestParam Long productId ) {
		Optional<User> user = userService.findById(productId);
		if(user.isPresent()) {
			Product product = productService.buyProduct(user.get(), productId);	
			return new ResponseEntity(product.getOwner().getUserName()+ "brought the Product with product name "+product.getName(),HttpStatus.OK);
		}
		return new ResponseEntity("user is not found",HttpStatus.NOT_FOUND);
		
	}
	
		
	

}
