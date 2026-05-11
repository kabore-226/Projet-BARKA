package com.barka.barka_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class VilleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVille;

    @Column(unique = true)
    private String codeVille;

    private String nomVille;

    private LocalDateTime createdAt;

    private Long createdBy; // ID USER

    private LocalDateTime updatedAt;
}