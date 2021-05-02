package com.lab.homework5.service.controller.assembler;

import com.lab.homework5.service.controller.PaymentController;
import com.lab.homework5.service.controller.model.PaymentModel;
import com.lab.homework5.service.dto.PaymentDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PaymentAssembler extends RepresentationModelAssemblerSupport<PaymentDto, PaymentModel> {
    public PaymentAssembler() {
        super(PaymentController.class, PaymentModel.class);
    }

    @Override
    public PaymentModel toModel(PaymentDto entity) {
        PaymentModel paymentModel = new PaymentModel(entity);

        Link get = linkTo(methodOn(PaymentController.class).getPayment(entity.getProductCode())).withRel("get");
        Link create = linkTo(methodOn(PaymentController.class).createPayment(entity)).withRel("create");
        Link update = linkTo(methodOn(PaymentController.class).updatePayment(entity.getProductCode(), entity)).withRel("update");
        Link delete = linkTo(methodOn(PaymentController.class).deletePayment(entity.getProductCode())).withRel("delete");

        paymentModel.add(get, create, update, delete);

        return paymentModel;
    }
}
