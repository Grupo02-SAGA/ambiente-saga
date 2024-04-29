package com.biopark.grupo2.controller;

import com.biopark.grupo2.model.Usuario;
import com.biopark.grupo2.repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UsuarioController {

    @Autowired
    private RepositoryUsuario repositoryUsuario;

    @GetMapping("/novoUsuario")
    public ModelAndView modelAndView(){
        Usuario usuario = new Usuario();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("novoUsuario");
        modelAndView.addObject("usuario", usuario);
        return modelAndView;
    }

    @PostMapping("/novoUsuario")
    public RedirectView createUsuario(@ModelAttribute ("usuario") Usuario usuario, RedirectAttributes attributes) {
        repositoryUsuario.save(usuario);
        attributes.addFlashAttribute("condition", "cadastro-ok");
        return new RedirectView("/novoUsuario");
    }

}