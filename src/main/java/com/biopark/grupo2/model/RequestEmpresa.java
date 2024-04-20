package com.biopark.grupo2.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestEmpresa(
        @NotBlank
        String fantasia,
        @NotBlank
        String razao_social,
        @NotBlank
        String cnpj,
        @NotBlank
        String email,
        @NotBlank
        String endereco,
        @NotBlank
        String telefone,
        @NotNull
        String porte,
        @NotNull
        String atividade) {
}
