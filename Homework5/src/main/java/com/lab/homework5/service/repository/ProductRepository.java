package com.lab.homework04.service.repository;

import com.lab.homework04.service.model.Product;

public interface ProductRepository {
    Product getProduct(String code);

    Product createProduct(Product product);

    Product updateProduct(String code, Product product);

    void deleteProduct(String code);
}
