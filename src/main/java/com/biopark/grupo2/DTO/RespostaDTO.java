package com.biopark.grupo2.DTO;

import com.biopark.grupo2.model.Formulario;
import com.biopark.grupo2.model.Pergunta;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespostaDTO {
    private Integer resposta;
    private String url_documento;
    private Formulario formulario;
    private List<Pergunta> perguntas;
    private Long id_certificado;
    private Long id_usuario;
}
