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
    private int id_pergunta;
    private String titulo;
    private boolean documento;
}
