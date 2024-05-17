package com.biopark.grupo2.controller;

import com.biopark.grupo2.model.Formulario;
import com.biopark.grupo2.model.Pergunta;
import com.biopark.grupo2.repository.RepositoryFormulario;
import com.biopark.grupo2.repository.RepositoryPergunta;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class CriarMaisController {

    @Autowired
    private RepositoryFormulario repositoryFormulario;

    @Autowired
    private RepositoryPergunta repositoryPergunta;

    @GetMapping("/detalhes_formulario/{id}")
    public ModelAndView getFormularioById(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Formulario formulario = repositoryFormulario.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Formulario não encontrado no get com o ID: " + id));
        Pergunta novaPergunta = new Pergunta();
        modelAndView.setViewName("detalhes_formulario");
        modelAndView.addObject("formulario", formulario);
        modelAndView.addObject("pergunta", novaPergunta);
        modelAndView.addObject("idFormulario", formulario.getId_formulario());
        modelAndView.addObject("listaPergunta", getQuestionsByFormId(id));
        return modelAndView;
    }

    @PostMapping("/detalhes_formulario")
    public RedirectView editarFormulario(@ModelAttribute("formulario") Formulario formulario, Long idFormulario, RedirectAttributes attributes) {
        Formulario formularioExistente = repositoryFormulario.findById(idFormulario)
                .orElseThrow(() -> new IllegalArgumentException("Formulario não encontrado no post com o ID: " + idFormulario));
        BeanUtils.copyProperties(formulario, formularioExistente, "id_formulario");
        repositoryFormulario.save(formularioExistente);
        attributes.addFlashAttribute("editar-formulario", "formulario-editado");
        return new RedirectView("/detalhes_formulario/" + idFormulario);
    }

    @PostMapping("/detalhes_formulario/criar_pergunta")
    public RedirectView criarPerguntas(@ModelAttribute("novaPergunta") Pergunta novaPergunta, Long idFormulario, RedirectAttributes attributes) {
        Formulario formulario = repositoryFormulario.findById(idFormulario)
                .orElseThrow(() -> new IllegalArgumentException("Formulario não encontrado no post criar-pergunta: " + idFormulario));
        novaPergunta.setFormulario(formulario);
        repositoryPergunta.save(novaPergunta);
        attributes.addFlashAttribute("criar-pergunta", "pergunta-criada");
        return new RedirectView("/detalhes_formulario/" + idFormulario);
    }

    public List<String> getQuestionsByFormId(Long id) {
        return repositoryPergunta.findTitlesByFormId(id);
    }
}