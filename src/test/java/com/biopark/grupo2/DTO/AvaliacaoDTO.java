package com.biopark.grupo2.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoDTO {
    private Integer base;
    private Date ultimaMod;
    private String fantasia;
    private String usuario;
    private Long id_formulario;
    private Long id_certificado;

}
