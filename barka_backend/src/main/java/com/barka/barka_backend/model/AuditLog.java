package com.barka.barka_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String userEmail;

    private String action;
    // CREATE_VILLE, DELETE_USER, UPDATE_VILLE...

    private String entity;

    private Long entityId;

    private String details;

    private LocalDateTime timestamp;

    private String ipAddress;
}