package com.learning.jpa.JPA;

import com.learning.jpa.JPA.entities.ProductEntity;
import com.learning.jpa.JPA.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
				.price(BigDecimal.valueOf(23.45))
				.quantity(12)
				.build();
		ProductEntity savedProduct = productRepository.save(productEntity);
		System.out.println(savedProduct);
	}

	@Test
	void getRepository(){
//		List<ProductEntity> productEntityList = productRepository.findByCreatedAtAfter(LocalDate.of(2025,1,1));

//		List<ProductEntity> productEntityList = productRepository.findByQuantityAndPrice(12, BigDecimal.valueOf(23.45));

		List<ProductEntity> productEntityList = productRepository.findByQuantityGreaterThanAndPriceLessThan(11, BigDecimal.valueOf(24.45));

//		List<ProductEntity> product = productRepository.findByTitleLike("%choco%");

//		List<ProductEntity> product = productRepository.findByTitleContaining("choco");

		List<ProductEntity> product = productRepository.findByTitleContainingIgnoreCase("CHOco");

		System.out.println(product);
	}

	@Test
	void getSingleFromRepository(){
		Optional<ProductEntity> product = productRepository.findByTitleAndPrice("Pepsi", BigDecimal.valueOf(14.4));

		System.out.println(product);
	}
}
