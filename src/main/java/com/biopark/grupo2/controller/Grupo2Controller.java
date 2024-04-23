package com.biopark.grupo2.controller;

import com.biopark.grupo2.model.Empresa;
import com.biopark.grupo2.repository.RepositoryEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Grupo2Controller {

    @Autowired
    private RepositoryEmpresa repositoryEmpresa;

    @GetMapping("/register")
    public String showForm(Model model) {
        Empresa empresa = new Empresa();
        model.addAttribute("empresa", empresa);
       return  "novaEmpresa";
    }
    @PostMapping("/register")
    public String createEmpresa(@ModelAttribute ("empresa") Empresa empresa) {
        repositoryEmpresa.save(empresa);
        return "novaEmpresa";
    }

}
