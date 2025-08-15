package com.learning.jpa.JPA.repositories;

import com.learning.jpa.JPA.entities.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> { // we pass the entity class and the type of the id

    // spring boot on its own write the custom query based on the function name.
    // Function name should be in the proper format for this to work

    List<ProductEntity> findByOrderByPrice();  // It will give us all the products and sort that on price

    // as of now it is tightly coupled to sort on different parameters we will need to write a new function
    // so to overcome this we can do something like this
    List<ProductEntity> findBy(Sort sort);

    List<ProductEntity> findByTitleOrderByPrice(String title);


    List<ProductEntity> findByCreatedAtAfter(LocalDate after);

    List<ProductEntity> findByQuantityAndPrice(int quantity, BigDecimal price);

    List<ProductEntity> findByQuantityGreaterThanAndPriceLessThan(int quantity, BigDecimal price);

    List<ProductEntity> findByTitleLike(String title);

    List<ProductEntity> findByTitleContaining(String title);

    List<ProductEntity> findByTitleContainingIgnoreCase(String title);

//    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);

    //writing our custom query
//    @Query("select e from ProductEntity e where e.title=?1 and e.price=?2")
    @Query("select e from ProductEntity e where e.title=:title and e.price=:price")
    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);
}
