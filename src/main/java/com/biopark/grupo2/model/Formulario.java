package com.biopark.grupo2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Formulario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFormulario;
    private String titulo;

    public Formulario() {
    }
    public Formulario(int idFormulario, String titulo) {
        this.idFormulario = idFormulario;
        this.titulo = titulo;
    }

    public int getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(int idFormulario) {
        this.idFormulario = idFormulario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Formulario that)) return false;
        return idFormulario == that.idFormulario;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFormulario);
    }
}
