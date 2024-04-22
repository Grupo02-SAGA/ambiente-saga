package com.biopark.grupo2.model;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name ="Formulario")
public class Formulario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idFormulario")
    private int idFormulario;
    @Column(name = "titulo")
    private String titulo;

    public Formulario(){

    }

    public Formulario(int idFormulario, String titulo, boolean base) {
        this.idFormulario = idFormulario;
        this.titulo = titulo;
        this.base = base;
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

    @Column(name = "base")
    private boolean base;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formulario that = (Formulario) o;
        return idFormulario == that.idFormulario && base == that.base && Objects.equals(titulo, that.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFormulario, titulo, base);
    }
}
