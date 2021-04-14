package com.lab.homework04.service.controller;

import com.lab.homework04.service.dto.ProductDto;
import com.lab.homework04.service.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl productService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{code}")
    public ProductDto getProduct(@PathVariable String code) {
        log.info("Getting product with code{}", code);
        return productService.getUser(code);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        log.info("Creating product{}", productDto);
        return productService.createProduct(productDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{code}")
    public ProductDto updateProduct(@PathVariable String code, @RequestParam ProductDto productDto) {
        log.info("Updating product with code{}", code);
        return productService.updateProduct(code, productDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String code) {
        log.info("Deleting Product with code{}", code);
        productService.deleteProduct(code);
        return ResponseEntity.noContent().build();
    }
}
