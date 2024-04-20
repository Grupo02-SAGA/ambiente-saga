package com.biopark.grupo2.model;

import jakarta.persistence.*;

import java.util.Objects;

public class Certificado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_certificado;
    private double resultado;
    private String vencimento;
    @ManyToOne
    @JoinColumn(name = "id_formulario")
    private Formulario id_formulario;
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa id_empresa;

    public Certificado() {
    }

    public Certificado(int id_certificado, double resultado, String vencimento, Formulario id_formulario, Empresa id_empresa) {
        this.id_certificado = id_certificado;
        this.resultado = resultado;
        this.vencimento = vencimento;
        this.id_formulario = id_formulario;
        this.id_empresa = id_empresa;
    }

    public int getId_certificado() {
        return id_certificado;
    }

    public void setId_certificado(int idCertificado) {
        this.id_certificado = idCertificado;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public Formulario getId_formulario() {
        return id_formulario;
    }

    public void setId_formulario(Formulario idFormulario) {
        this.id_formulario = idFormulario;
    }

    public Empresa getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(Empresa idEmpresa) {
        this.id_empresa = idEmpresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Certificado that)) return false;
        return id_certificado == that.id_certificado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_certificado);
    }
}
