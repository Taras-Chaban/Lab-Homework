package com.lab.homework5.service.controller.assembler;

import com.lab.homework5.service.controller.InvoiceController;
import com.lab.homework5.service.controller.model.InvoiceModel;
import com.lab.homework5.service.dto.InvoiceDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class InvoiceAssembler extends RepresentationModelAssemblerSupport<InvoiceDto, InvoiceModel> {

    public InvoiceAssembler() {
        super(InvoiceController.class, InvoiceModel.class);
    }

    @Override
    public InvoiceModel toModel(InvoiceDto entity) {
        InvoiceModel invoiceModel = new InvoiceModel(entity);

        Link get = linkTo(methodOn(InvoiceController.class).getInvoice(entity.getCode())).withRel("get");
        Link create = linkTo(methodOn(InvoiceController.class).createInvoice(entity)).withRel("create");
        Link update = linkTo(methodOn(InvoiceController.class).updateInvoice(entity.getCode(), entity)).withRel("update");
        Link delete = linkTo(methodOn(InvoiceController.class).deleteInvoice(entity.getCode())).withRel("delete");

        invoiceModel.add(get, create, update, delete);

        return invoiceModel;
    }
}
