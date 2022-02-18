package com.sda.javaee9spring.controller.rest;


import com.sda.javaee9spring.entity.ProductEntity;
import com.sda.javaee9spring.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class ProductRestController {

    private final ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {this.productService = productService;}

    @GetMapping("/products")
    public List<ProductEntity> findAllProducts(){
        log.info("findAllProducts()");

        return productService.readAllProductEntities();
    }

    @GetMapping("/products/{id}")
    public ProductEntity findProductEntityById(@PathVariable("id") Long productId) {
        log.info("trying to find person entity by id: [{}", productId);

        return productService.readProductEntityById(productId);
    }
}
