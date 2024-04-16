package com.biopark.grupo2.controller;

import com.biopark.grupo2.model.Formulario;
import com.biopark.grupo2.model.Pergunta;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Grupo2Controller {
    @GetMapping("/")
    public ModelAndView grupo2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("criarMais");
        return modelAndView;
    }

    @PostMapping("/imprimeTitulo")
    public String criarMaisTitulo(@ModelAttribute Formulario formulario,
                            @ModelAttribute Pergunta pergunta,
                            Model model) {
        model.addAttribute("titulo", formulario.getTitulo());
        return "criarMais";
    }
    @PostMapping("/imprimePergunta")
    public String criarMaisPergunta(@ModelAttribute Formulario formulario,
                                    @ModelAttribute Pergunta pergunta,
                                    Model model){
        //pegar os que tem fk do id fornecido
        while (.next){
            model.addAttribute("tituloPergunta",.titulo())
        }
        return "criarMais";
    }
}
