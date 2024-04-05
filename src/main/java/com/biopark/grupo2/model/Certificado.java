package com.biopark.grupo2.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Certificado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCertificado;
    private double resultado;
    private String vencimento;
    @ManyToOne
    @JoinColumn(name = "formulario_id")
    private int idFormulario;
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private int idEmpresa;

    public Certificado() {
    }

    public Certificado(int idCertificado, double resultado, String vencimento, int idFormulario, int idEmpresa) {
        this.idCertificado = idCertificado;
        this.resultado = resultado;
        this.vencimento = vencimento;
        this.idFormulario = idFormulario;
        this.idEmpresa = idEmpresa;
    }

    public int getIdCertificado() {
        return idCertificado;
    }

    public void setIdCertificado(int idCertificado) {
        this.idCertificado = idCertificado;
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

    public int getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(int idFormulario) {
        this.idFormulario = idFormulario;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Certificado that)) return false;
        return idCertificado == that.idCertificado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCertificado);
    }
}
