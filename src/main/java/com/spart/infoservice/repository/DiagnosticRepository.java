package com.spart.infoservice.repository;

import com.spart.infoservice.repository.model.Diagnostic;
import com.spart.infoservice.repository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
   public interface DiagnosticRepository extends JpaRepository<Diagnostic, Long> {
        Optional<Diagnostic> findById(Long userId);

        List<Diagnostic> findAllByUser(User user);
    }

