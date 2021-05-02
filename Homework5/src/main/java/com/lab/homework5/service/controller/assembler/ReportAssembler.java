package com.lab.homework5.service.controller.assembler;

import com.lab.homework5.service.controller.ReportController;
import com.lab.homework5.service.controller.model.ReportModel;
import com.lab.homework5.service.dto.ReportDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ReportAssembler extends RepresentationModelAssemblerSupport<ReportDto, ReportModel> {

    public ReportAssembler() {
        super(ReportController.class, ReportModel.class);
    }

    @Override
    public ReportModel toModel(ReportDto entity) {
        ReportModel reportModel = new ReportModel(entity);

        Link get = linkTo(methodOn(ReportController.class).getReport(entity.getDate())).withRel("get");
        Link create = linkTo(methodOn(ReportController.class).createReport(entity)).withRel("create");
        Link delete = linkTo(methodOn(ReportController.class).deleteReport(entity.getDate())).withRel("delete");

        reportModel.add(get, create, delete);

        return reportModel;
    }
}
