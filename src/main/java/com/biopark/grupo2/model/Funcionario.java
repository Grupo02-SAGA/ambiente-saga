package com.biopark.grupo2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Funcionario extends Usuario {
    private boolean administrador;
    @Id
    private Long id_funcionario;

    // Construtores
    public Funcionario() {
    }

    public Funcionario(String senha, String nome, String sobrenome, String cpf, String telefone, String email, String cidade, boolean administrador) {
        super();
        this.administrador = administrador;
    }

    //  novo atributo
    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    // toString

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + Integer.toString(getId()) +
                ", senha='" + getSenha() + '\'' +
                ", nome='" + getNome() + '\'' +
                ", sobrenome='" + getSobrenome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", cidade='" + getCidade() + '\'' +
                ", administrador=" + administrador +
                '}';
    }


    private int getId() {

        return 0;
    }

    public void setId_funcionario(Long idFuncionario) {
        this.id_funcionario = idFuncionario;
    }

    public Long getId_funcionario() {
        return id_funcionario;
    }
}
