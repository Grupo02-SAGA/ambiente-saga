package com.biopark.grupo2.controller;

import com.biopark.grupo2.model.Formulario;
import com.biopark.grupo2.model.FormularioPergunta;
import com.biopark.grupo2.model.Pergunta;
import com.biopark.grupo2.repository.RepositoryFormulario;
import com.biopark.grupo2.repository.RepositoryPergunta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
public class CriarMaisController {

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
            model.addAttribute("perguntas", getQuestionsByFormId(id));
            model.addAttribute("formularioId", id);
            model.addAttribute("novaPergunta", new Pergunta());
        }
        return "criarMais";
    }
    @PostMapping("/detalhesDeFormulario/{id}")
    public String criarPerguntas(@ModelAttribute("novaPergunta") Pergunta novaPergunta, @RequestParam("formularioId") Long formularioId, Model model){
        Formulario formulario = repositoryFormulario.findById(formularioId).orElseThrow();
        novaPergunta.setFormulario(formulario);

        perguntaRepository.save(novaPergunta);

        return "redirect:/detalhesDeFormulario/" + formularioId;
    }
    public List<String> getQuestionsByFormId(Long id_formulario) {
        return perguntaRepository.findTitlesByFormId(id_formulario);
    }
}



