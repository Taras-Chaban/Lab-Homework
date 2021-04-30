package com.lab.homework5.service.repository;

import com.lab.homework5.service.model.Product;

public interface ProductRepository {
    Product getProduct(String code);

    Product createProduct(Product product);

    Product updateProduct(String code, Product product);

    void deleteProduct(String code);
}
