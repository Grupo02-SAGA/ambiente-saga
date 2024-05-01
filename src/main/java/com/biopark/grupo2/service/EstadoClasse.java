package com.biopark.grupo2.service;

import com.biopark.grupo2.model.Formulario;
import com.biopark.grupo2.repository.RepositoryFormulario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoClasse {

    @Autowired
    private RepositoryFormulario repositoryFormulario;

    public String consultarEstado(Long id) {
        Formulario formulario = repositoryFormulario.findById(id).orElse(null);
        if (formulario != null) {
            boolean status = formulario.getStatus();
            return "true";
        } else {
            return "Formulário não encontrado";
        }
    }

    public String alterarEstado(Long id, boolean novoEstado) {
        Formulario formulario = repositoryFormulario.findById(id).orElse(null);
        if (formulario != null) {
            formulario.setStatus(novoEstado);
            repositoryFormulario.save(formulario);
            return "Estado Alterado";
        } else {
            return "Formulário não encontrado";
        }
    }
}
