package com.biopark.grupo2.controller;

import com.biopark.grupo2.model.Usuario;
import com.biopark.grupo2.repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioController {

    @Autowired
    private RepositoryUsuario repositoryUsuario;

    @GetMapping("/register")
    public String showForm(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return  "novoUsuario";
    }
    @PostMapping("/register")
    public String createEmpresa(@ModelAttribute Usuario usuario) {
        repositoryUsuario.save(usuario);
        return "novoUsuario";
    }

}