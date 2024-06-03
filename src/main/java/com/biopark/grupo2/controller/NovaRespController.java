package com.biopark.grupo2.controller;

import com.biopark.grupo2.model.Empresa;
import com.biopark.grupo2.model.Formulario;
import com.biopark.grupo2.repository.RepositoryEmpresa;
import com.biopark.grupo2.repository.RepositoryFormulario;
import com.biopark.grupo2.repository.RepositoryResposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NovaRespController {

    @Autowired
    private RepositoryFormulario repositoryFormulario;
    @Autowired
    private RepositoryEmpresa repositoryEmpresa;

    @GetMapping("/novaResposta")
    public ModelAndView paginaNovaResposta(){
        Formulario formulario = new Formulario();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("novoRespForm");
        modelAndView.addObject("forms",todosFormularios());
        modelAndView.addObject("empresas", todasEmpresas());
        return modelAndView;
    }

    public List<Formulario> todosFormularios(){
        return repositoryFormulario.findAll();
    }

    public List<Empresa> todasEmpresas(){
        return repositoryEmpresa.findAll();
    }

}
