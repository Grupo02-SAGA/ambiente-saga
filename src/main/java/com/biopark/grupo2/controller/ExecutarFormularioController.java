package com.biopark.grupo2.controller;

import com.biopark.grupo2.DTO.RespostaDTO;
import com.biopark.grupo2.model.Formulario;
import com.biopark.grupo2.model.Pergunta;
import com.biopark.grupo2.repository.RepositoryCertificado;
import com.biopark.grupo2.repository.RepositoryFormulario;
import com.biopark.grupo2.repository.RepositoryPergunta;
import com.biopark.grupo2.repository.RepositoryResposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

public class ExecutarFormularioController {

    @Autowired
    private RepositoryFormulario repositoryFormulario;

    @Autowired
    private RepositoryPergunta repositoryPergunta;

    @Autowired
    private RepositoryResposta repositoryResposta;

    @Autowired
    private RepositoryCertificado repositoryCertificado;

    @GetMapping("/executarFormulario/{id}")
    public ModelAndView executarFormulaioById(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Formulario formulario = repositoryFormulario.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Formulario não encontrado no get com o ID: " + id));

        List<Pergunta> perguntas = formulario.getPerguntas();

        RespostaDTO respostaDTO = new RespostaDTO();
        respostaDTO.setFormulario(formulario);
        respostaDTO.setPerguntas(perguntas);

        modelAndView.setViewName("executarFormulario");
        modelAndView.addObject("resposta", respostaDTO);
        return modelAndView;
    }
}
