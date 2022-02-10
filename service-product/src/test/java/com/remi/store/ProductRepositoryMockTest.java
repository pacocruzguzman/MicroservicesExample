package com.remi.store;

import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.remi.store.entity.Category;
import com.remi.store.entity.Product;
import com.remi.store.repository.IProductRepository;

@DataJpaTest
public class ProductRepositoryMockTest {

	@Autowired
	private IProductRepository productRepository;

	@Test
	public void whenFindByCategory_thenReturnProduct() {
		Product product01 = Product.builder()
				.name("computer")
				.category(Category.builder().id(1L).build())
				.description("")
				.stock(Double.parseDouble("10"))
				.price(Double.parseDouble("1240.99"))
				.status("Created")
				.createAt(new Date()).build();
		
		productRepository.save(product01);
		
		List<Product> founds = productRepository.findByCategory(product01.getCategory());
		
		Assertions.assertThat(founds.size()).isEqualTo(3);
	}
}
