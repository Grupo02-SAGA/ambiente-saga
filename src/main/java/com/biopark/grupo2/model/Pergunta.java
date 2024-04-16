package com.biopark.grupo2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Pergunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pergunta;
    private String titulo;
    private boolean documento;

    public Pergunta() {
    }

    public Pergunta(int id_pergunta, String titulo, boolean documento) {
        this.id_pergunta = id_pergunta;
        this.titulo = titulo;
        this.documento = documento;
    }

    public int getId_pergunta() {
        return id_pergunta;
    }

    public void setId_pergunta(int idPergunta) {
        this.id_pergunta = idPergunta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String pergunta) {
        this.titulo = pergunta;
    }

    public boolean isDocumento() {
        return documento;
    }

    public void setDocumento(boolean documento) {
        this.documento = documento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pergunta pergunta)) return false;
        return id_pergunta == pergunta.id_pergunta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_pergunta);
    }
}
