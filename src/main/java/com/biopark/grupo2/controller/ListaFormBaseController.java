package com.biopark.grupo2.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Arrays;
import java.util.List;

@Controller
public class ListaFormBaseController {

    @GetMapping("/listarForm")
    public String listaNomes(Model model) {
        List<String> nomes = Arrays.asList("Nome1", "Nome2", "Nome3"); // Aqui você terá sua lógica para obter os nomes
        model.addAttribute("nomes", nomes);
        return "sua_pagina"; // Substitua "sua_pagina" pelo nome do seu arquivo HTML
    }
}
