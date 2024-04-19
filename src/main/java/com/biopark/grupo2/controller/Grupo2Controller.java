package com.biopark.grupo2.controller;

import com.biopark.grupo2.model.Formulario;
import com.biopark.grupo2.repository.RepositoryFormulario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class Grupo2Controller {
    @Autowired
    private RepositoryFormulario repositoryFormulario;

    public String getTituloFormularioPorId(int idFormulario) {
        Optional<Formulario> formulario = repositoryFormulario.findByidFormulario(idFormulario);
        return formulario.isPresent() ? formulario.get().getTitulo() : "Formulário não encontrado";
    }

    @GetMapping("/")
    public String grupo2(Model model) {
        model.addAttribute("titulo", getTituloFormularioPorId(1));
        return "criarMais";
    }
}

