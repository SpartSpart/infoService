package com.spart.infoservice.controller.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class DiagnosticDto {

    @NotNull
    @NotEmpty
    private String name;
    private String description;
    private String recommendation;
    @NotNull
    private LocalDate date;
//    private List<Image> imageList;
}

