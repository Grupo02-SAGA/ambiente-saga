
package com.biopark.grupo2.controller;

import java.util.List;

import com.biopark.grupo2.model.Usuario;
import com.biopark.grupo2.repository.RepositoryUsuario;
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

@RestController
@RequestMapping("/usuarios")
public class FuncionarioController {
    @Autowired
    private RepositoryUsuario repositoryUsuario;
    @GetMapping("/assessment")
    public String index() {
        return "index";
    }
    @GetMapping
    public List<Usuario> listarUsuario() {
        return repositoryUsuario.findAll();
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return repositoryUsuario.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
        return repositoryUsuario.findById(id)
                .map(usuario -> {
                    usuario.setNome(usuarioAtualizado.getNome());
                    usuario.setEmail(usuarioAtualizado.getEmail());
                    return repositoryUsuario.save(usuario);
                })
                .orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        repositoryUsuario.deleteById(id);
    }
}
