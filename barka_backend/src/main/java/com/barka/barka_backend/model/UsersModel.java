package com.barka.barka_backend.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 👤 Informations utilisateur
    @Column(nullable = false, length = 150)
    private String nom;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    // 🔐 Mot de passe crypté
    @Column(nullable = false)
    private String password;

    // 🔐 Rôle utilisateur
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    // 🚦 Statut utilisateur
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserStatus status;

    // 🔒 Sécurité compte
    @Builder.Default
    @Column(nullable = false)
    private Boolean accountNonLocked = true;

    @Builder.Default
    @Column(nullable = false)
    private Boolean enabled = true;

    // 🗑 Suppression logique
    @Builder.Default
    @Column(nullable = false)
    private Boolean deleted = false;

    // 📊 Dernière connexion
    private LocalDateTime lastLogin;

    // 📅 Dates automatiques
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}