package com.biopark.grupo2.controller;

import com.biopark.grupo2.model.Formulario;
import com.biopark.grupo2.repository.RepositoryFormulario;
import com.biopark.grupo2.repository.RepositoryPergunta;
import com.biopark.grupo2.service.FormularioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;


@Controller
public class CriarMaisController {

    @Autowired
    private FormularioService formularioService;

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
            model.addAttribute("formulario", formulario);
        }
        return "criarMais";
    }

    public List<String> getQuestionsByFormId(Long id_formulario) {
        return perguntaRepository.findTitlesByFormId(id_formulario);
    }

    @PutMapping("/detalhesDeFormulario/{id}")
    public RedirectView atualizarFormulario(@ModelAttribute("formulario") Formulario formulario, @PathVariable Long id, RedirectAttributes attributes){
        Formulario atualizarFormulario = repositoryFormulario.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Formulario não encontrado com o ID: " + id));
        if (atualizarFormulario != null) {
            BeanUtils.copyProperties(formulario, atualizarFormulario, "id_formulario");
            repositoryFormulario.save(atualizarFormulario);
            attributes.addFlashAttribute("condition", "cadastro-ok");
            return new RedirectView("/detalhesDeFormulario/" + id);
        } else {
            return new RedirectView("/popup-de-erro"); /* vai ser implementado ainda*/
        }
    }
}




