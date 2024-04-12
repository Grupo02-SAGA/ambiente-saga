package com.biopark.grupo2.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "usuario_empresa")
public class Usuario_Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuarioEmpresa;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Usuario_Empresa() {
    }
    public Usuario_Empresa(int idUsuarioEmpresa, Usuario usuario, Empresa empresa) {
        this.idUsuarioEmpresa = idUsuarioEmpresa;
        this.usuario = usuario;
        this.empresa = empresa;
    }

    public int getIdUsuarioEmpresa() {
        return idUsuarioEmpresa;
    }
    public void setIdUsuarioEmpresa(int idUsuarioEmpresa) {
        this.idUsuarioEmpresa = idUsuarioEmpresa;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Empresa getEmpresa() {
        return empresa;
    }
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario_Empresa that)) return false;
        return idUsuarioEmpresa == that.idUsuarioEmpresa;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuarioEmpresa);
    }
}

