package com.biopark.grupo2.controller;

import com.biopark.grupo2.model.Empresa;
import com.biopark.grupo2.model.ResquestEmpresa;
import com.biopark.grupo2.repository.RepositoryEmpresa;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/novaEmpresa")
public class Grupo2Controller {

    @Autowired
    private RepositoryEmpresa repositoryEmpresa;

    @GetMapping("/")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("novaEmpresa");
        return  modelAndView;
    }
    @GetMapping("/mostrarForm")
    public ResponseEntity getAllEmpresas(){
        var allEmpresas = repositoryEmpresa.findAll();
        return ResponseEntity.ok(allEmpresas);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping
    public ResponseEntity createEmpresa(@RequestBody @Valid ResquestEmpresa resquestEmpresa){
        Empresa newEmpresa = new Empresa(resquestEmpresa);
        repositoryEmpresa.save(newEmpresa);
        return  ResponseEntity.ok().build();
    }
}
