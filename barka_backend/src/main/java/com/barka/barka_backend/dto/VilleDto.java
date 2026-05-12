package com.barka.barka_backend.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VilleDto {

    private Long idVille;

    private String codeVille;

    private String nomVille;

    private Long createdBy;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}