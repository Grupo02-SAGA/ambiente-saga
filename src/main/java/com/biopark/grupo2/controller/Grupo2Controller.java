package com.biopark.grupo2.controller;

import com.biopark.grupo2.model.Empresa;
import com.biopark.grupo2.model.RequestEmpresa;
import com.biopark.grupo2.repository.RepositoryEmpresa;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/novaEmpresa")
public class Grupo2Controller {

    @Autowired
    private RepositoryEmpresa repositoryEmpresa;

    @GetMapping("/")
    public String showForm() {
       return  "novaEmpresa";
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping
    public ResponseEntity createEmpresa(@RequestBody @Valid RequestEmpresa requestEmpresas){
        Empresa newEmpresa = new Empresa(requestEmpresas);
        repositoryEmpresa.save(newEmpresa);
        return  ResponseEntity.ok().build();
    }
}
