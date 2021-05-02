package com.lab.homework5.service.controller;

import com.lab.homework5.service.api.ProductApi;
import com.lab.homework5.service.dto.ProductDto;
import com.lab.homework5.service.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/products")
@RequiredArgsConstructor
public class ProductController implements ProductApi {
    private final ProductServiceImpl productService;

    @Override
    public ProductDto getProduct(String code) {
        log.info("Getting product with code {}", code);
        return productService.getUser(code);
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        log.info("Creating product {}", productDto);
        return productService.createProduct(productDto);
    }

    @Override
    public ProductDto updateProduct(String code, ProductDto productDto) {
        log.info("Updating product with code {}", code);
        return productService.updateProduct(code, productDto);
    }

    @Override
    public ResponseEntity<Void> deleteProduct(String code) {
        log.info("Deleting Product with code {}", code);
        productService.deleteProduct(code);
        return ResponseEntity.noContent().build();
    }
}
