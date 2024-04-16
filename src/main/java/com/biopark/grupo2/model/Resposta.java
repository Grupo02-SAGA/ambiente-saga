package com.biopark.grupo2.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_resposta;
    private String resposta;
    private String observacao;
    @ManyToOne
    @JoinColumn(name = "id_formulario")
    private Formulario id_formulario;
    @ManyToOne
    @JoinColumn(name = "id_pergunta")
    private Pergunta id_pergunta;
    @ManyToOne
    @JoinColumn(name = "id_certificado")
    private Certificado id_certificado;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario id_usuario;

    public Resposta() {
    }
    public Resposta(int id_resposta, String resposta, String observacao, Formulario id_formulario, Pergunta id_pergunta, Certificado id_certificado, Usuario id_usuario) {
        this.id_resposta = id_resposta;
        this.resposta = resposta;
        this.observacao = observacao;
        this.id_formulario = id_formulario;
        this.id_pergunta = id_pergunta;
        this.id_certificado = id_certificado;
        this.id_usuario = id_usuario;
    }

    public int getId_resposta() {
        return id_resposta;
    }

    public void setId_resposta(int idResposta) {
        this.id_resposta = idResposta;
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

    public Formulario getId_formulario() {
        return id_formulario;
    }

    public void setId_formulario(Formulario idFormulario) {
        this.id_formulario = idFormulario;
    }

    public Pergunta getId_pergunta() {
        return id_pergunta;
    }

    public void setId_pergunta(Pergunta idPergunta) {
        this.id_pergunta = idPergunta;
    }

    public Certificado getId_certificado() {
        return id_certificado;
    }

    public void setId_certificado(Certificado idCertificado) {
        this.id_certificado = idCertificado;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario idUsuario) {
        this.id_usuario = idUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resposta resposta)) return false;
        return id_resposta == resposta.id_resposta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_resposta);
    }
}
