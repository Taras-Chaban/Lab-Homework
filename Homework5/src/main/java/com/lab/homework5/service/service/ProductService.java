package com.lab.homework5.service.service;

import com.lab.homework5.service.dto.ProductDto;

public interface ProductService {
    ProductDto getUser(String code);

    ProductDto createProduct(ProductDto productDto);

    ProductDto updateProduct(String code, ProductDto productDto);

    void deleteProduct(String code);
}
