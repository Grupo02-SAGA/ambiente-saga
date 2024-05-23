package com.biopark.grupo2.controller;

import com.biopark.grupo2.model.Usuario;
import com.biopark.grupo2.repository.RepositoryUsuario;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private RepositoryUsuario repositoryUsuario;

    @GetMapping("/novoUsuario")
    public ModelAndView modelAndView(){
        Usuario usuario = new Usuario();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("novoUsuario");
        modelAndView.addObject("usuario", usuario);
        return modelAndView;
    }

    @PostMapping("/novoUsuario")
    public RedirectView createUsuario(@ModelAttribute ("usuario") Usuario usuario, RedirectAttributes attributes) {
        repositoryUsuario.save(usuario);
        attributes.addFlashAttribute("condition", "cadastro-ok");
        return new RedirectView("/novoUsuario");
    }

    @GetMapping("/editarUsuario/{id}")
    public ModelAndView getUsuarioById(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editarUsuario"); // Defina o nome da sua página de detalhes do usuário
        // Buscar usuário pelo ID
        Usuario usuario = repositoryUsuario.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com o ID: " + id));
        // Adicionar o usuário ao modelo
        modelAndView.addObject("usuario", usuario);
        return modelAndView;
    }

    @PostMapping("/editarUsuario")
    public RedirectView editarUsuario(@ModelAttribute("usuario") Usuario usuario, RedirectAttributes attributes) {
        // Carregar o usuário existente do banco de dados
        Usuario usuarioExistente = repositoryUsuario.findById((long)usuario.getId_usuario())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com o ID: " + usuario.getId_usuario()));
        // Atualizar os atributos do usuário existente com os novos dados do formulário
        BeanUtils.copyProperties(usuario, usuarioExistente, "id_usuario");
        // Salvar o usuário atualizado no banco de dados
        repositoryUsuario.save(usuarioExistente);
        attributes.addFlashAttribute("condition", "cadastro-ok");
        return new RedirectView("/editarUsuario/" + usuario.getId_usuario());
    }

    public List<Usuario> findAllUsuarios(){
        return repositoryUsuario.findAll();
    }

    @Autowired
    @GetMapping("/listaUsuarios")
    public ModelAndView listaUsuarios() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("listaUsuarios");
        modelAndView.addObject("usuarios", findAllUsuarios());
        return modelAndView;
    }

}