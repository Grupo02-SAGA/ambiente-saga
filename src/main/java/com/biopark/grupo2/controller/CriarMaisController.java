package com.biopark.grupo2.controller;

import com.biopark.grupo2.model.Formulario;
import com.biopark.grupo2.repository.RepositoryFormulario;
import com.biopark.grupo2.repository.RepositoryPergunta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


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
            model.addAttribute("idFormulario", id);
        }
        return "criarMais";
    }
    public List<String> getQuestionsByFormId(Long id_formulario) {
        return perguntaRepository.findTitlesByFormId(id_formulario);
    }

    @PostMapping("{idFormulario}/pergunta/{id}/atualizar-ativo")///pergunta/'+ ${pergunta.id_pergunta} + '/atualizar-ativo}
    public String atualizarAtivo(@PathVariable Long id) {
        perguntaRepository.atualizarAtivoPorId(id, false);
        return "redirect:/detalhesDeFormulario/{idFormulario}";
    }
}



