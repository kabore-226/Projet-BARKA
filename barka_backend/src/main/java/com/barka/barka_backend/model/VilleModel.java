package com.barka.barka_backend.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "villes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VilleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVille;

    // 🏙 Code unique de la ville
    @Column(nullable = false, unique = true, length = 50)
    private String codeVille;

    // 🏙 Nom de la ville
    @Column(nullable = false, length = 150)
    private String nomVille;

    // 👤 ID utilisateur ayant créé la ville
    @Column(nullable = false)
    private Long createdBy;

    // 🗑 Suppression logique
    @Builder.Default
    @Column(nullable = false)
    private Boolean deleted = false;

    // 📅 Date création automatique
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    // 📅 Date modification automatique
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}