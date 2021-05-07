package com.lab.homework6.service.api;

import com.lab.homework6.service.dto.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface ProductApi {
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{code}")
    ProductDto getProduct(@PathVariable String code);

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    ProductDto createProduct(@RequestBody ProductDto productDto);

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{code}")
    ProductDto updateProduct(@PathVariable String code, @RequestParam ProductDto productDto);

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{code}")
    ResponseEntity<Void> deleteProduct(@PathVariable String code);
}
