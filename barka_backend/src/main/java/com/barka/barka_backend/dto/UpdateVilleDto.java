package com.barka.barka_backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateVilleDto {

    private String codeVille;

    private String nomVille;
}