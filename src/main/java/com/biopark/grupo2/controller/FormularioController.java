package com.biopark.grupo2.controller;
import com.biopark.grupo2.model.Formulario;
import com.biopark.grupo2.model.Usuario;
import com.biopark.grupo2.repository.RepositoryFormulario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class FormularioController {

    @Autowired
    private RepositoryFormulario repositoryFormulario;

    @GetMapping("/lista_forms_base")
    public ModelAndView lista_forms_base() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("lista_forms_base");
        modelAndView.addObject("forms",forms_base());
        return modelAndView;
    }

    @PostMapping("/lista_forms_base")
    public RedirectView criarForm(@ModelAttribute ("formulario") Formulario formulario, RedirectAttributes attributes){
        Formulario formularioSalvo = repositoryFormulario.save(formulario);
        attributes.addFlashAttribute("condition", "cadastro-ok");
        Long idFormulario = formularioSalvo.getId_formulario();
        return new RedirectView("/detalhesDeFormulario/" + idFormulario);
    }
    public List<Formulario> forms_base(){
        return repositoryFormulario.findAll();
    }

}