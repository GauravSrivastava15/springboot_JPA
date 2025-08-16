package com.learning.jpa.JPA.controllers;

import com.learning.jpa.JPA.entities.ProductEntity;
import com.learning.jpa.JPA.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    private final Integer PAGE_SIZE = 5;

    ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "0") Integer pageNumber){
//        return productRepository.findByOrderByPrice();

//        return productRepository.findBy(Sort.by(Sort.Direction.DESC,sortBy)); // we are sorting it in descending order while passing Sort type to the repository

        // another way create and pass the sort object
//        return productRepository.findBy(Sort.by(
//                Sort.Order.asc(sortBy) // we can chain multiple sort function to this if two properties are similar than we can write another Sort
//        ));

//        Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE);  // creating pageable instance

//        Pageable pageable = PageRequest.of(
//                pageNumber,
//                PAGE_SIZE,
//                Sort.by(sortBy)
//        );



        return productRepository.findByTitleContainingIgnoreCase(
                title,
                PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(sortBy))
        ) ;
    }

}
