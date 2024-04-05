package com.biopark.grupo2.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Documentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDocumentos;
    private String urlDocumento;
    @ManyToOne
    @JoinColumn(name = "id_resposta")
    private int idResposta;

    public Documentos() {
    }

    public Documentos(int idDocumentos, String urlDocumento, int idResposta) {
        this.idDocumentos = idDocumentos;
        this.urlDocumento = urlDocumento;
        this.idResposta = idResposta;
    }

    public int getIdDocumentos() {
        return idDocumentos;
    }

    public void setIdDocumentos(int idDocumentos) {
        this.idDocumentos = idDocumentos;
    }

    public String getUrlDocumento() {
        return urlDocumento;
    }

    public void setUrlDocumento(String urlDocumento) {
        this.urlDocumento = urlDocumento;
    }

    public int getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(int idResposta) {
        this.idResposta = idResposta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Documentos that)) return false;
        return idDocumentos == that.idDocumentos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDocumentos);
    }
}
