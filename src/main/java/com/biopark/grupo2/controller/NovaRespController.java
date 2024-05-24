package com.biopark.grupo2.controller;

import com.biopark.grupo2.model.Formulario;
import com.biopark.grupo2.repository.RepositoryResposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NovaRespController {

    @Autowired
    private RepositoryResposta repositoryResposta;

    @GetMapping("/novaResposta")
    public ModelAndView paginaNovaResposta(){
        Formulario formulario = new Formulario();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("novoRespForm");
        return modelAndView;
    }

}
