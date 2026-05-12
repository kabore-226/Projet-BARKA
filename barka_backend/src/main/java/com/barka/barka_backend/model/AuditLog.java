package com.barka.barka_backend.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "audit_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 👤 Utilisateur concerné
    private Long userId;

    @Column(length = 150)
    private String userEmail;

    // ⚡ Action effectuée
    @Column(nullable = false, length = 100)
    private String action;

    // 📦 Entité concernée
    @Column(length = 100)
    private String entity;

    private Long entityId;

    // 🌐 Informations requête
    @Column(length = 10)
    private String method;

    private Integer statusCode;

    @Column(length = 100)
    private String ipAddress;

    // 📝 Détails supplémentaires
    @Column(length = 5000)
    private String details;

    // 📊 Date action
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime timestamp;
}