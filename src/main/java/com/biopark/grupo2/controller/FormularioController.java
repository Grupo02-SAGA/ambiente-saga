package com.biopark.grupo2.controller;
import com.biopark.grupo2.model.Formulario;
import com.biopark.grupo2.repository.RepositoryFormulario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RestController
//@RequestMapping(value = "/lista_forms_base")
public class FormularioController {

    @Autowired
    private RepositoryFormulario repositoryFormulario;



    @GetMapping("/lista_forms_base")
    public List<Formulario> findAll(){
        List<Formulario> result = repositoryFormulario.findAll();
        return result;
    }
    @GetMapping(value = "/{id}")
    public Formulario findById(@PathVariable Long id){
        Formulario result = repositoryFormulario.findById(id).get();
        return result;
    }

    @PostMapping
    public Formulario insert(@RequestBody Formulario formulario) {
        Formulario result = repositoryFormulario.save(formulario);
        return result;
    }

}