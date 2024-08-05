package com.biopark.grupo2.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespostaDTO {
    private Map<Long, Integer> respostas;

    private List<MultipartFile> nomeDocumento;
    @NotNull
    private Long id_formulario;
    private List<Long> id_perguntas;
    @NotNull
    private Long id_certificado;
    @NotNull
    private Long id_empresa;

    private static final Long ID_USUARIO_FIXO = 1L;

    public Long getId_usuario(){
        return ID_USUARIO_FIXO;
    }
}
