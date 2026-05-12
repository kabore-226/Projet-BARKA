package com.barka.barka_backend.service;

import com.barka.barka_backend.model.SystemLog;
import com.barka.barka_backend.repository.SystemLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SystemLogService {

    private final SystemLogRepository systemLogRepository;

    public SystemLog save(SystemLog systemLog) {
        return systemLogRepository.save(systemLog);
    }
}