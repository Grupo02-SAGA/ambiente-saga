
package com.biopark.grupo2.controller;

import java.util.List;

import com.biopark.grupo2.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.biopark.grupo2.model.Funcionario;
import com.biopark.grupo2.repository.RepositoryFuncionario;

@RestController
@RequestMapping("/usuarios")
public class FuncionarioController {
    @Autowired
    private RepositoryFuncionario repositoryFuncionario;
    @GetMapping("/assessment")
    public String index() {
        return "index";
    }
    @GetMapping
    public List<Funcionario> listarFuncionario() {
        return repositoryFuncionario.findAll();
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping
    public Funcionario criarFuncionario(@RequestBody Funcionario funcionario) {
        return repositoryFuncionario.save(funcionario);
    }

    @PutMapping("/{id}")
    public Funcionario atualizarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionarioAtualizado) {
        return repositoryFuncionario.findById(id)
                .map(funcionario -> {
                    funcionario.setNome(funcionarioAtualizado.getNome());
                    funcionario.setEmail(funcionarioAtualizado.getEmail());
                    return repositoryFuncionario.save(funcionario);
                })
                .orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        repositoryFuncionario.deleteById(id);
    }
}
