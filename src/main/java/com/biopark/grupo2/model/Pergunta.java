package com.biopark.grupo2.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Table(name = "Pergunta")
@Entity(name = "pergunta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id_pergunta")
public class Pergunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pergunta")
    private int id_pergunta;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "documento")
    private boolean documento;

    @ManyToOne
    @JoinColumn(name = "id_formulario")
    private Formulario formulario;
}
