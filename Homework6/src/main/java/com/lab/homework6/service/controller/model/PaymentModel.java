package com.lab.homework6.service.controller.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.lab.homework6.service.dto.PaymentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
public class PaymentModel extends RepresentationModel<PaymentModel> {
    @JsonUnwrapped
    private PaymentDto paymentDto;
}
