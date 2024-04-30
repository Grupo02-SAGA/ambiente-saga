package com.biopark.grupo2.model;

import jakarta.persistence.*;

import lombok.*;

@Table(name = "Formulario_Pergunta")
@Entity(name = "formulario_Pergunta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Formulario_Pergunta {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_formulario")
    private Formulario id_formulario;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_pergunta")
    private Pergunta id_pergunta;
}
