package com.biopark.grupo2.controller;

import com.biopark.grupo2.model.Empresa;
import com.biopark.grupo2.model.ResquestEmpresas;
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
    private RepositoryEmpresa empresa;

    @GetMapping("/")
    public ModelAndView showForm() {
       ModelAndView modelAndView = new ModelAndView();
       modelAndView.setViewName("novaEmpresa");
       return  modelAndView;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping
    public ResponseEntity createEmpresa(@RequestBody @Valid ResquestEmpresas requestEmpresas){
        Empresa newEmpresa = new Empresa(requestEmpresas);
        empresa.save(newEmpresa);
        return  ResponseEntity.ok().build();
    }
}
