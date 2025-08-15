package com.learning.jpa.JPA.controllers;

import com.learning.jpa.JPA.entities.ProductEntity;
import com.learning.jpa.JPA.repositories.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductRepository productRepository;

    ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "id") String sortBy){
//        return productRepository.findByOrderByPrice();

//        return productRepository.findBy(Sort.by(Sort.Direction.DESC,sortBy)); // we are sorting it in descending order while passing Sort type to the repository

        // another way create and pass the sort object
        return productRepository.findBy(Sort.by(
                Sort.Order.asc(sortBy) // we can chain multiple sort function to this if two properties are similar than we can write another Sort
        ));
    }

}
