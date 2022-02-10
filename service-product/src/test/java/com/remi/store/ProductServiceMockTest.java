package com.remi.store;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.remi.store.entity.Product;
import com.remi.store.entity.Category;
import com.remi.store.repository.IProductRepository;
import com.remi.store.service.IProductService;
import com.remi.store.service.ProductServiceImpl;

@SpringBootTest
public class ProductServiceMockTest {

	@Mock
	private IProductRepository productRepository;

	private IProductService productService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		productService = new ProductServiceImpl(productRepository);

		Product computer = Product.builder().id(1L).name("computer").category(Category.builder().id(1L).build())
				.price(Double.parseDouble("12.5")).stock(Double.parseDouble("5")).build();

		Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(computer));
		Mockito.when(productRepository.save(computer)).thenReturn(computer);
	}
	
	 @Test
	   public void whenValidGetID_ThenReturnProduct(){
	        Product found = productService.getProduct(1L);
	       Assertions.assertThat(found.getName()).isEqualTo("computer");

	   }
	 


	   @Test
	   public void whenValidUpdateStock_ThenReturnNewStock(){
	        Product newStock = productService.updateStock(1L,Double.parseDouble("8"));
	        Assertions.assertThat(newStock.getStock()).isEqualTo(13);
	   }
}
