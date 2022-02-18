package com.sda.javaee9spring.service;

import com.sda.javaee9spring.entity.ProductEntity;
import com.sda.javaee9spring.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) { this.productRepository = productRepository; }

    public List<ProductEntity> readAllProductEntities(){
        log.info("Trying to read all product entities");

        var result = productRepository.findAll();
        log.info("Product entities read from db: {}", result);
        return result;
    }

    public ProductEntity readProductEntityById(Long id){
        log.info("read entity by id: [{}]", id);

        Optional<ProductEntity> maybeProduct = productRepository.findById(id);
        ProductEntity result = null;
        if (maybeProduct.isPresent()){
            result = maybeProduct.get();
        }
        log.info("found Product entity: [{}]", result);
        return result;
    }
}
