package com.spart.infoservice.service.impl;

import com.spart.infoservice.controller.dto.DiagnosticDto;
import com.spart.infoservice.controller.dto.UserDto;
import com.spart.infoservice.mapper.DiagnosticMapper;
import com.spart.infoservice.mapper.UserMapper;
import com.spart.infoservice.repository.DiagnosticRepository;
import com.spart.infoservice.repository.UserRepository;
import com.spart.infoservice.repository.model.Diagnostic;
import com.spart.infoservice.repository.model.User;
import com.spart.infoservice.service.DiagnosticService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiagnosticServiceImpl implements DiagnosticService {
    private final DiagnosticRepository diagnosticRepository;
    private final UserDetailsServiceImpl userDetailsServiceImpl;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final DiagnosticMapper diagnosticMapper;


    @Override
    public Long addDiagnostic(DiagnosticDto diagnosticDto) {
        Diagnostic diagnostic = diagnosticMapper.toEntity(diagnosticDto);
        diagnostic.setUser((userDetailsServiceImpl.getUser()));
        diagnosticRepository.save(diagnostic);
        return diagnostic.getId();
    }

    @Override
    public List<DiagnosticDto> getDiagnostic() {
        List<Diagnostic> diagnosticList = diagnosticRepository.findAllByUser(userDetailsServiceImpl.getUser());
        return diagnosticMapper.toListDto(diagnosticList);
    }

}
