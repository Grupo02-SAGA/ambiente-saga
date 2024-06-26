package com.biopark.grupo2.service;

import com.biopark.grupo2.DTO.AvaliacaoDTO;
import com.biopark.grupo2.model.Formulario;
import com.biopark.grupo2.repository.RepositoryFormulario;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormularioService {

    @Autowired
    private RepositoryFormulario repositoryFormulario;

    public Formulario consultarFormulario(Long id_formulario) {
        Formulario formularioBuscado = repositoryFormulario.findById(id_formulario).orElse(null);
        return formularioBuscado;
    }

    public Formulario alterarFormulario(Long id_formulario, Formulario formulario) {
        Formulario formularioExistente = consultarFormulario(id_formulario);
        if (formularioExistente != null) {
            if (formulario != null) {
                BeanUtils.copyProperties(formulario, formularioExistente, "id_formulario");
                formularioExistente = repositoryFormulario.save(formularioExistente);
                return formularioExistente;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public Page<Formulario> findFormulariosLista(int page, int size, Boolean estado, String searchTerm) {
        Page<Formulario> resultados = null;
        PageRequest pageable = PageRequest.of(page, size);
        if (searchTerm != null && !searchTerm.isEmpty()) {
            resultados = repositoryFormulario.findFormularioByNome(searchTerm, pageable);
        } else {
            if (estado){
                resultados = repositoryFormulario.findPaginadoAtivo(pageable);
            }else{
                resultados = repositoryFormulario.findPaginadoInativo(pageable);
            }
        }
        return resultados;
    }
}