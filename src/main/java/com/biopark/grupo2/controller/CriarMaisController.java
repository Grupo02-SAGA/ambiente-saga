package com.biopark.grupo2.controller;

import com.biopark.grupo2.model.Formulario;
import com.biopark.grupo2.repository.RepositoryFormulario;
import com.biopark.grupo2.repository.RepositoryPergunta;
import com.biopark.grupo2.service.FormularioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class CriarMaisController {

    @Autowired
    private RepositoryFormulario repositoryFormulario;
    @Autowired
    private RepositoryPergunta perguntaRepository;

    @Autowired
    private FormularioService formularioService;

    @GetMapping("/detalhesDeFormulario/{id}")
    public String exibirCriarMais(@PathVariable Long id, Model model) {
        Optional<Formulario> formularioOpt = repositoryFormulario.findById(id);
        if (formularioOpt.isPresent()) {
            Formulario formulario = formularioOpt.get();
            model.addAttribute("titulo", formulario.getTitulo());
            model.addAttribute("perguntas", getQuestionsByFormId(id));
        }
        return "criarMais";
    }
    public List<String> getQuestionsByFormId(Long id_formulario) {
        return perguntaRepository.findTitlesByFormId(id_formulario);
    }
    @PostMapping("/atualizarform/{id}")
    public String atualizarFormulario(@PathVariable Long id, @RequestBody Formulario formulario) {
        Formulario atualizarFormulario = formularioService.alterarFormulario(id, formulario);
        if (atualizarFormulario != null) {
            return "redirect:/detalhesDeFormulario/" + id;
        } else {
            return null;
        }
    }
}



