package com.biopark.grupo2.controller;

import com.biopark.grupo2.model.Usuario;
import com.biopark.grupo2.repository.RepositoryLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private RepositoryLogin usuarioRepository;

    @GetMapping
    public String showLoginPage(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping
    public String login(@RequestParam String email, @RequestParam String senha, Model model) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmailAndSenha(email, senha);
        if (usuarioOpt.isPresent()) {
            // Login realizado, redireciona para a home
            return "redirect:/lista_forms_base";
        } else {
            // Mensagem de erro
            model.addAttribute("error", "Email ou senha inválidos.");
            return "login";
        }
    }
}
