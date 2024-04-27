package com.biopark.grupo2.model;

import jakarta.persistence.*;
@Entity
@Table(name = "Formulario_pergunta")
public class Formulario_Pergunta {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_formulario")
    private Formulario id_formulario;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_pergunta")
    private Pergunta id_pergunta;

    public Formulario_Pergunta() {
    }
    public Formulario_Pergunta(int idFormularioPergunta, Formulario id_formulario, Pergunta id_pergunta) {
        this.id_formulario = id_formulario;
        this.id_pergunta = id_pergunta;
    }

    public Formulario getId_formulario() {
        return id_formulario;
    }

    public void setId_formulario(Formulario formulario) {
        this.id_formulario = formulario;
    }

    public Pergunta getId_pergunta() {
        return id_pergunta;
    }

    public void setId_pergunta(Pergunta pergunta) {
        this.id_pergunta = pergunta;
    }
}
