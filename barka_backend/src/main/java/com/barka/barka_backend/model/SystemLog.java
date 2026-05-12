package com.barka.barka_backend.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "system_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SystemLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // INFO, WARN, ERROR
    @Column(nullable = false, length = 20)
    private String level;

    @Column(nullable = false, length = 5000)
    private String message;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime timestamp;
}