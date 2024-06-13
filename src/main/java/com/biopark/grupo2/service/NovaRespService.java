package com.biopark.grupo2.service;

import com.biopark.grupo2.model.*;
import org.springframework.stereotype.Service;

@Service
public class NovaRespService {
    public Certificado novoCertificado(Formulario formulario, Empresa empresa){
        Certificado certificado = new Certificado();
        certificado.setId_formulario(formulario);
        certificado.setId_empresa(empresa);
        certificado.setId_certificado(formulario.getId_formulario());
        return certificado;
    }

    public Formulario novoFormulario(Formulario formulario, Empresa empresa){
        Formulario novoFormulario = new Formulario();
        novoFormulario.setTitulo(formulario.getTitulo());
        novoFormulario.setTitulo(empresa.getFantasia());
        novoFormulario.setBase(false);
        novoFormulario.setEstado(true);
        return novoFormulario;
    }

    public Pergunta todasRespostas(Pergunta pergunta, Formulario id_form){
        Pergunta novaPergunta = new Pergunta();
        novaPergunta.setTitulo(pergunta.getTitulo());
        novaPergunta.setDocumento(pergunta.isDocumento());
        novaPergunta.setEstado(pergunta.isEstado());
        novaPergunta.setId_formulario(id_form);
        return novaPergunta;
    }
}
