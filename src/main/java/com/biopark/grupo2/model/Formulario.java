package com.biopark.grupo2.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity(name = "formulario")
@Table(name ="formulario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id_formulario")

public class Formulario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_formulario")
    private int id_formulario;

    @Column(name = "titulo")
    private String titulo;

    @Column(name="base")
    private Boolean base;
}