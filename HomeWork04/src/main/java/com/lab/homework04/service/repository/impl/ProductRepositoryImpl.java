package com.lab.homework04.service.repository.impl;


import com.lab.homework04.service.model.Product;
import com.lab.homework04.service.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class ProductRepositoryImpl implements ProductRepository {
    private final List<Product> productList = new ArrayList<>();

    @Override
    public Product getProduct(String code) {
        Product product = productList.stream()
                .filter(p -> p.getCode().equals(code))
                .findFirst()
                .orElseThrow(RuntimeException::new);
        log.info("Get Product by code{} ", code);
        return product;
    }

    @Override
    public Product createProduct(Product product) {
        productList.add(product);
        log.info("Created product{}", product);
        return product;
    }

    @Override
    public Product updateProduct(String code, Product product) {
        boolean isDeleted = productList.removeIf(p -> p.getCode().equals(code));
        if (isDeleted) {
            productList.add(product);
            log.info("Product {} was updated", product);
        } else {
            log.info("Product does not exist");
            throw new RuntimeException("Product does not exist");
        }
        return product;
    }

    @Override
    public void deleteProduct(String code) {
        boolean isDeleted = productList.removeIf(product -> product.getCode().equals(code));
        if (!isDeleted) {
            log.info("Product with code {} does not exist", code);
            throw new RuntimeException("Product does not exist");
        } else {
            log.info("Product with code {} was deleted", code);
        }
    }
}
