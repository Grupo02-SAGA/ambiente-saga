package com.biopark.grupo2.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "formulario")
@Entity(name = "formulario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id_formulario")
public class Formulario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_formulario;
    private String titulo;
    private Boolean base;
    private Boolean estado;

    @OneToMany(mappedBy = "formulario", cascade = CascadeType.ALL)
    private List<Pergunta> perguntas;
}
