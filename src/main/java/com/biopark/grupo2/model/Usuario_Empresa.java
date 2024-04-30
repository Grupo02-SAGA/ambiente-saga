package com.biopark.grupo2.model;

import jakarta.persistence.*;
@Entity
@Table(name = "Usuario_empresa")
public class Usuario_Empresa {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario id_usuario;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa id_empresa;

    public Usuario_Empresa() {
    }

    public Usuario_Empresa(Usuario id_usuario, Empresa id_empresa) {
        this.id_usuario = id_usuario;
        this.id_empresa = id_empresa;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario usuario) {
        this.id_usuario = usuario;
    }

    public Empresa getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(Empresa empresa) {
        this.id_empresa = empresa;
    }

}

