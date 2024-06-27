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
    private String nomeDocumento;
    private Formulario formulario;
    private List<Pergunta> perguntas;
    private Long id_certificado;
    private Integer id_usuario;
}
