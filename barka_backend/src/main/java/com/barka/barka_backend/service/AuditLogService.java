package com.barka.barka_backend.service;

import com.barka.barka_backend.model.AuditLog;
import com.barka.barka_backend.repository.AuditLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuditLogService {

    private final AuditLogRepository auditLogRepository;

    public AuditLog save(AuditLog auditLog) {
        return auditLogRepository.save(auditLog);
    }
}