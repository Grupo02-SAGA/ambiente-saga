package com.biopark.grupo2.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Documentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_documento;
    private String url_documento;
    private boolean validado;
    @ManyToOne
    @JoinColumn(name = "id_resposta")
    private Resposta id_resposta;

    public Documentos() {
    }

    public Documentos(int id_documento, String url_documento, Resposta id_resposta) {
        this.id_documento = id_documento;
        this.url_documento = url_documento;
        this.id_resposta = id_resposta;
    }

    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int idDocumentos) {
        this.id_documento = idDocumentos;
    }

    public String getUrl_documento() {
        return url_documento;
    }

    public void setUrl_documento(String urlDocumento) {
        this.url_documento = urlDocumento;
    }

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }

    public Resposta getId_resposta() {
        return id_resposta;
    }

    public void setId_resposta(Resposta idResposta) {
        this.id_resposta = idResposta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Documentos that)) return false;
        return id_documento == that.id_documento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_documento);
    }
}
