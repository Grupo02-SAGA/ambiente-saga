package com.biopark.grupo2.DTO;

import lombok.*;

import java.sql.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoDTO {
    private Integer base;
    private Date vencimento;
    private String form;
    private String fantasia;
    private String usuario;
    private Long id_certificado;

}
