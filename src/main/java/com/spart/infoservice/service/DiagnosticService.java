package com.spart.infoservice.service;

import com.spart.infoservice.controller.dto.DiagnosticDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DiagnosticService {

    Long addDiagnostic(DiagnosticDto diagnosticDto);

    List<DiagnosticDto> getDiagnostic ();
}
