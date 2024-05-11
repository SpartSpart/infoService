package com.spart.infoservice.mapper;

import com.spart.infoservice.controller.dto.DiagnosticDto;
import com.spart.infoservice.controller.dto.UserDto;
import com.spart.infoservice.repository.model.Diagnostic;
import com.spart.infoservice.repository.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DiagnosticMapper {

    DiagnosticDto toDto(Diagnostic diagnostic);

    Diagnostic toEntity(DiagnosticDto diagnosticDto);

    List<DiagnosticDto> toListDto(List<Diagnostic> diagnosticList);
}
