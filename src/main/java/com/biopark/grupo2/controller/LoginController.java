package com.biopark.grupo2.controller;

import com.biopark.grupo2.model.Usuario;
import com.biopark.grupo2.repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private RepositoryUsuario usuarioRepository;

    @GetMapping("/login")
    public ModelAndView showLoginPage() {
        ModelAndView mav = new ModelAndView("login");
        mav.setViewName("login");
        mav.addObject("usuario", new Usuario());
        return mav;
    }


    @PostMapping("/login")
    public RedirectView login(@RequestParam String email, @RequestParam String senha) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmailAndSenha(email, senha);
        if (usuarioOpt.isPresent()) {
            // Login realizado, redireciona para a home
            return new RedirectView("/listaAvaliacoes");
        } else {
            // Mensagem de erro
            return new RedirectView ("/login");
        }
    }
}
