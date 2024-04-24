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
@EqualsAndHashCode(of = "idFormulario")

public class Formulario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idFormulario")
    private int idFormulario;
    @Column(name = "titulo")
    private String titulo;
}