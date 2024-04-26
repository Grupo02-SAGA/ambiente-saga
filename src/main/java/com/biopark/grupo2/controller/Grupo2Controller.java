package com.biopark.grupo2.controller;

import com.biopark.grupo2.model.Formulario;
import com.biopark.grupo2.repository.RepositoryFormulario;
import com.biopark.grupo2.repository.RepositoryPergunta;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.Optional;

@Controller
public class Grupo2Controller {

    @Autowired
    private RepositoryFormulario repositoryFormulario;
    @Autowired
    private RepositoryPergunta perguntaRepository;

    @GetMapping("/detalhesDeFormulario/{id}")
    public String exibirCriarMais(@PathVariable Long id, Model model) {
        Optional<Formulario> formularioOpt = repositoryFormulario.findById(id);
        if (formularioOpt.isPresent()) {
            Formulario formulario = formularioOpt.get();
            model.addAttribute("titulo", formulario.getTitulo());
            model.addAttribute("pergunta", getQuestionsByFormId(id));
        }
        return "criarMais";
    }
    public List<String> getQuestionsByFormId(Long id_formulario) {
        return perguntaRepository.findTitlesByFormId(id_formulario);
    }
}



