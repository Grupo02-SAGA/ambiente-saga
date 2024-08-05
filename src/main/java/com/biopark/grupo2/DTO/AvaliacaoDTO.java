package com.biopark.grupo2.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoDTO {
    private Integer base;
    private LocalDateTime ultimaMod;
    private String fantasia;
    private String usuario;
    private Long id_formulario;
    private Long id_certificado;
}
