package com.lab.homework5.service.controller.assembler;

import com.lab.homework5.service.controller.ProductController;
import com.lab.homework5.service.controller.model.ProductModel;
import com.lab.homework5.service.dto.ProductDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductAssembler extends RepresentationModelAssemblerSupport<ProductDto, ProductModel> {

    public ProductAssembler() {
        super(ProductController.class, ProductModel.class);
    }

    @Override
    public ProductModel toModel(ProductDto entity) {
        ProductModel productModel = new ProductModel(entity);

        Link get = linkTo(methodOn(ProductController.class).getProduct(entity.getCode())).withRel("get");
        Link create = linkTo(methodOn(ProductController.class).createProduct(entity)).withRel("create");
        Link update = linkTo(methodOn(ProductController.class).updateProduct(entity.getCode(), entity)).withRel("update");
        Link delete = linkTo(methodOn(ProductController.class).deleteProduct(entity.getCode())).withRel("delete");

        productModel.add(get, create, update, delete);

        return productModel;
    }
}
