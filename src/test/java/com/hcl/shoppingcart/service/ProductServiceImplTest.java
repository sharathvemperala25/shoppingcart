package com.hcl.shoppingcart.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.shoppingcart.entity.Product;
import com.hcl.shoppingcart.repository.ProductRepository;
import com.hcl.shoppingcart.service.impl.ProductServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {
	
	@InjectMocks
	ProductService productService = new ProductServiceImpl();
	
	@Mock
	ProductRepository ProductRepository;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void getAllProductsTest() {
		List<Product> listOfproducts = new ArrayList();
		listOfproducts.add(new Product(1L,"moto",10000,"mobile"));
		listOfproducts.add(new Product(1L,"moto2",10000,"mobile"));
		listOfproducts.add(new Product(1L,"moto3",10000,"mobile"));
		Mockito.when(productService.getAllProducts()).thenReturn(listOfproducts);
		List<Product> returnedlist = productService.getAllProducts();
		
		assertThat(returnedlist.equals(listOfproducts));
	}
	
	@Test
	public void getProductByNameTest() {
		Product product = new Product(1L,"moto",10000,"mobile");
		Mockito.when(productService.findByName("moto")).thenReturn(Optional.of(product));
		Optional<Product> returnedProduct = productService.findByName("moto");
		assertThat(returnedProduct.equals(product));
	}

}
