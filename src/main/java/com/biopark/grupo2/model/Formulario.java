package com.biopark.grupo2.model;

import jakarta.persistence.*;

import java.util.Objects;

public class Formulario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_formulario;
    private String titulo;
    private boolean base;

    public Formulario() {
    }
    public Formulario(int id_formulario, String titulo) {
        this.id_formulario = id_formulario;
        this.titulo = titulo;
    }

    public int getId_formulario() {
        return id_formulario;
    }

    public void setId_formulario(int idFormulario) {
        this.id_formulario = idFormulario;
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
        return id_formulario == that.id_formulario;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_formulario);
    }
}
