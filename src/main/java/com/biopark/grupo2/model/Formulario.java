package com.biopark.grupo2.model;
import jakarta.persistence.*;

import java.util.Objects;

import lombok.*;

@Table(name = "Formulario")
@Entity(name = "formulario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id_fomulario")

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
