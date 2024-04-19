package com.biopark.grupo2.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Formulario {
    @Id
    @Column(name = "id_fomulario")
    private int idFormulario;
    private String titulo;
    private boolean base;

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

    public boolean isBase() {
        return base;
    }

    public void setBase(boolean base) {
        this.base = base;
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
