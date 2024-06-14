package com.biopark.grupo2.controller;

import com.biopark.grupo2.model.Usuario;
import com.biopark.grupo2.repository.RepositoryLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private RepositoryLogin usuarioRepository;

    @GetMapping("/login")
    public ModelAndView showLoginPage() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("usuario", new Usuario());
        return mav;
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String email, @RequestParam String senha) {
        ModelAndView mav = new ModelAndView();
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmailAndSenha(email, senha);
        if (usuarioOpt.isPresent()) {
            // Login realizado, redireciona para a home
            mav.setViewName("redirect:/");
        } else {
            // Mensagem de erro
            mav.setViewName("redirect:/login");
        }
        return mav;
    }
}
