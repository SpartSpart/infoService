package com.spart.infoservice.controller;

import com.spart.infoservice.controller.dto.DiagnosticDto;
import com.spart.infoservice.controller.dto.UserDto;
import com.spart.infoservice.service.DiagnosticService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.Diagnostics;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/healthmonitoring")
@RequiredArgsConstructor
public class HealthMonitoringController {

    private final DiagnosticService diagnosticService;

    @PostMapping()
    @PreAuthorize("isAuthenticated()")
    public Long addDiagnostic(@RequestBody @Valid DiagnosticDto diagnosticDto) {
        return diagnosticService.addDiagnostic(diagnosticDto);
    }

    @GetMapping()
    @PreAuthorize("isAuthenticated()")
    public List<DiagnosticDto> getDiagnosticList() {
        return diagnosticService.getDiagnostic();
    }

}
