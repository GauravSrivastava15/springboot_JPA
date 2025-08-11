package com.learning.jpa.JPA;

import com.learning.jpa.JPA.entities.ProductEntity;
import com.learning.jpa.JPA.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class JpaTutorialApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){
		ProductEntity productEntity = ProductEntity.builder()
				.sku("nestle234")
				.title("nestle chocolate")
				.price(BigDecimal.valueOf(123.54))
				.quantity(20)
				.build();
		ProductEntity savedProduct = productRepository.save(productEntity);
		System.out.println(savedProduct);
	}

	@Test
	void getRepository(){
		List<ProductEntity> productEntityList = productRepository.findByTitle("Pepsi");
		System.out.println(productEntityList);
	}
}
