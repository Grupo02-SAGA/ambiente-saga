package com.biopark.grupo2.controller;

import com.biopark.grupo2.model.Formulario;
import com.biopark.grupo2.repository.RepositoryFormulario;
import com.biopark.grupo2.repository.RepositoryPergunta;
import com.biopark.grupo2.service.FormularioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class CriarMaisController {

    @Autowired
    private FormularioService formularioService;

   /* @Autowired
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
        }
        return "criarMais";
    }
    public List<String> getQuestionsByFormId(Long id_formulario) {
        return perguntaRepository.findTitlesByFormId(id_formulario);
    }
}*/

    @GetMapping("/alterarFormulario/{id}")
    public ModelAndView modelAndView( @PathVariable("id") Long id_formulario) {
        Formulario formulario = formularioService.consultarFormulario(id_formulario);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("criarMais");
        modelAndView.addObject("formulario", formulario);
        return modelAndView;
    }

    @PostMapping("/alterarFormulario/{id}")
    public RedirectView atualizarFormulario(@PathVariable Long id, @RequestBody Formulario formulario, RedirectAttributes attributes) {
        Formulario atualizarFormulario = formularioService.alterarFormulario(id, formulario);
        if (atualizarFormulario != null) {
            attributes.addFlashAttribute("condition", "cadastro-ok");
            return  new RedirectView ("/alterarFormulario/" + formulario.getId_formulario());
        } else {
            return null;
        }
    }
}



