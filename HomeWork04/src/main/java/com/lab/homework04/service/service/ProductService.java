package com.lab.homework04.service.service;

import com.lab.homework04.service.dto.ProductDto;

public interface ProductService {
    ProductDto getUser(String code);

    ProductDto createUser(ProductDto productDto);

    ProductDto updateProduct(String code, ProductDto productDto);

    void deleteProduct(String code);
}
