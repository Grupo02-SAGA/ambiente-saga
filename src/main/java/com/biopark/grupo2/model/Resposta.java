package com.biopark.grupo2.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "Resposta")
@Entity(name = "Resposta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id_resposta")
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_resposta;
    private Integer resposta;
    private Integer id_usuario;

    @ManyToOne
    @JoinColumn(name = "id_formulario")
    private Formulario id_formulario;
    @ManyToOne
    @JoinColumn(name = "id_pergunta")
    private Pergunta id_pergunta;
    @ManyToOne
    @JoinColumn(name = "id_certificado")
    private Certificado id_certificado;

    private Date ultimaMod;
}
