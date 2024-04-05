package com.biopark.grupo2.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idResposta;
    private String resposta;
    private String observacao;
    @ManyToOne
    @JoinColumn(name = "id_formulario")
    private int idFormulario;
    @ManyToOne
    @JoinColumn(name = "id_pergunta")
    private int idPergunta;
    @ManyToOne
    @JoinColumn(name = "id_certificado")
    private int idCertificado;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private int idUsuario;

    public Resposta(int idResposta, String resposta, String observacao, int idFormulario, int idPergunta, int idCertificado, int idUsuario) {
        this.idResposta = idResposta;
        this.resposta = resposta;
        this.observacao = observacao;
        this.idFormulario = idFormulario;
        this.idPergunta = idPergunta;
        this.idCertificado = idCertificado;
        this.idUsuario = idUsuario;
    }

    public int getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(int idResposta) {
        this.idResposta = idResposta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(int idFormulario) {
        this.idFormulario = idFormulario;
    }

    public int getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(int idPergunta) {
        this.idPergunta = idPergunta;
    }

    public int getIdCertificado() {
        return idCertificado;
    }

    public void setIdCertificado(int idCertificado) {
        this.idCertificado = idCertificado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Resposta() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resposta resposta)) return false;
        return idResposta == resposta.idResposta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idResposta);
    }
}
