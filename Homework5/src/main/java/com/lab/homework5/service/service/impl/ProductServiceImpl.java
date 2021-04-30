package com.lab.homework5.service.service.impl;

import com.lab.homework5.service.dto.ProductDto;
import com.lab.homework5.service.model.Product;
import com.lab.homework5.service.repository.ProductRepository;
import com.lab.homework5.service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ProductDto getUser(String code) {
        Product product = productRepository.getProduct(code);
        return mapProductToProductDto(product);
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = productRepository.createProduct(mapProductDtoToProduct(productDto));
        return mapProductToProductDto(product);
    }

    @Override
    public ProductDto updateProduct(String code, ProductDto productDto) {
        Product product = productRepository.updateProduct(code, mapProductDtoToProduct(productDto));
        return mapProductToProductDto(product);
    }

    @Override
    public void deleteProduct(String code) {
        productRepository.deleteProduct(code);
    }

    private ProductDto mapProductToProductDto(Product product) {
        return ProductDto.builder()
                .code(product.getCode())
                .isAvailable(product.getIsAvailable())
                .name(product.getName())
                .description(product.getDescription())
                .cost(product.getCost())
                .quantity(product.getQuantity())
                .reservedQuantity(product.getReservedQuantity())
                .build();
    }

    private Product mapProductDtoToProduct(ProductDto productDto) {
        return Product.builder()
                .code(productDto.getCode())
                .isAvailable(productDto.getIsAvailable())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .cost(productDto.getCost())
                .quantity(productDto.getQuantity())
                .reservedQuantity(productDto.getReservedQuantity())
                .build();
    }
}
