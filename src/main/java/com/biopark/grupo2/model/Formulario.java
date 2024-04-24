package com.biopark.grupo2.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "Fomulario")
@Entity(name = "formulario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id_fomulario")

public class Formulario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFormulario;
    private String titulo;
    private boolean base;
}
