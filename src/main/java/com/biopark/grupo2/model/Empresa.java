package com.biopark.grupo2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;
@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_empresa;
    private String fantasia;
    private String razaoSocial;
    private String cnpj;
    private String email;
    private String endereco;
    private String telefone;
    private String porte;
    private String atividade;

    public Empresa(int id_empresa, String fantasia, String razaoSocial, String cnpj, String email, String endereco, String telefone, String porte, String atividade) {
        this.id_empresa = id_empresa;
        this.fantasia = fantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.porte = porte;
        this.atividade = atividade;
    }

    public Empresa() {
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int idEmpresa) {
        this.id_empresa = idEmpresa;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return id_empresa == empresa.id_empresa;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_empresa);
    }
}
