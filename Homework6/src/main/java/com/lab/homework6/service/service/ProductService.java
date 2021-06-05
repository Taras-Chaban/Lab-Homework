package com.lab.homework6.service.service;

import com.lab.homework6.service.dto.ProductDto;

public interface ProductService {
    ProductDto getProduct(String code);

    ProductDto createProduct(ProductDto productDto);

    ProductDto updateProduct(String code, ProductDto productDto);

    void deleteProduct(String code);
}
