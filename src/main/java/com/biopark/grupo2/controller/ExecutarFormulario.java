package com.biopark.grupo2.controller;

import com.biopark.grupo2.model.Formulario;
import com.biopark.grupo2.model.Pergunta;
import com.biopark.grupo2.model.Resposta;
import com.biopark.grupo2.repository.RepositoryCertificado;
import com.biopark.grupo2.repository.RepositoryFormulario;
import com.biopark.grupo2.repository.RepositoryPergunta;
import com.biopark.grupo2.repository.RepositoryResposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ExecutarFormulario {

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
        List<Pergunta>perguntas = formulario.getPerguntas();
        Resposta novaResposta = new Resposta();
        modelAndView.setViewName("executarFormulario");
        modelAndView.addObject("formulario", formulario);
        modelAndView.addObject("perguntas", perguntas);
        modelAndView.addObject("resposta", novaResposta);
        return modelAndView;
    }
}
