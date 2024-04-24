package com.biopark.grupo2.controller;

import com.biopark.grupo2.model.Formulario;
import com.biopark.grupo2.repository.RepositoryFormulario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class Grupo2Controller {
    @Autowired
    private RepositoryFormulario repositoryFormulario;
    @GetMapping("/criarMais")
    public String showForm(Model model) {
        Formulario formulario = new Formulario();
        model.addAttribute("titulo", formulario);
        return "criarMais";
    }
}

