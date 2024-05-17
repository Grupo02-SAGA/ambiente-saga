package com.biopark.grupo2.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Table(name = "pergunta")
@Entity(name = "pergunta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id_pergunta")
public class Pergunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pergunta;
    private String titulo;
    private boolean documento;
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_formulario")
    private Formulario formulario;
}
