package com.biopark.grupo2.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "formulario_pergunta")
public class Formulario_pergunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFormularioPergunta;
    @ManyToOne
    @JoinColumn(name = "formulario_id")
    private Formulario formulario;
    @ManyToOne
    @JoinColumn(name = "pergunta_id")
    private Pergunta pergunta;

    public Formulario_pergunta() {
    }
    public Formulario_pergunta(int idFormularioPergunta, Formulario formulario, Pergunta pergunta) {
        this.idFormularioPergunta = idFormularioPergunta;
        this.formulario = formulario;
        this.pergunta = pergunta;
    }

    public int getIdFormularioPergunta() {
        return idFormularioPergunta;
    }

    public void setIdFormularioPergunta(int idFormularioPergunta) {
        this.idFormularioPergunta = idFormularioPergunta;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Formulario_pergunta that)) return false;
        return idFormularioPergunta == that.idFormularioPergunta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFormularioPergunta);
    }
}
