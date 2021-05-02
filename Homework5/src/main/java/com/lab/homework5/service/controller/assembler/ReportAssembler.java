package com.lab.homework5.service.controller.assembler;

import com.lab.homework5.service.controller.ReportController;
import com.lab.homework5.service.controller.model.ReportModel;
import com.lab.homework5.service.dto.ReportDto;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class ReportAssembler extends RepresentationModelAssemblerSupport<ReportDto, ReportModel> {

    public ReportAssembler() {
        super(ReportController.class, ReportModel.class);
    }

    @Override
    public ReportModel toModel(ReportDto entity) {
        return null;
    }
}
