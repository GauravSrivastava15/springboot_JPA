package com.learning.jpa.JPA.repositories;

import com.learning.jpa.JPA.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByTitle(String title); // we pass the entity class and the type of the id

}
