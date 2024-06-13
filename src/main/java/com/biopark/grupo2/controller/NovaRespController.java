package com.biopark.grupo2.controller;

import com.biopark.grupo2.model.Empresa;
import com.biopark.grupo2.model.Formulario;
import com.biopark.grupo2.model.Pergunta;
import com.biopark.grupo2.repository.RepositoryCertificado;
import com.biopark.grupo2.repository.RepositoryEmpresa;
import com.biopark.grupo2.repository.RepositoryFormulario;
import com.biopark.grupo2.repository.RepositoryPergunta;
import com.biopark.grupo2.service.NovaRespService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
public class NovaRespController {

    @Autowired
    private RepositoryFormulario repositoryFormulario;
    @Autowired
    private RepositoryEmpresa repositoryEmpresa;
    @Autowired
    private RepositoryCertificado repositoryCertificado;
    @Autowired
    private RepositoryPergunta repositoryPergunta;

    @GetMapping("/executarAvaliacao")
    public ModelAndView paginaNovaResposta(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("novoRespForm");
        modelAndView.addObject("forms",todosFormularios());
        modelAndView.addObject("empresas", todasEmpresas());
        return modelAndView;
    }

    @Autowired
    NovaRespService novaRespService;

    @PostMapping("/novaAvaliacao")
    public RedirectView criarResposta(@RequestParam("id_empresa")Long id_empresa,
                                      @RequestParam("id_formulario")Long id_formulario){
        repositoryCertificado.save(novaRespService.novoCertificado(encontraFormPorId(id_formulario), encontraEmpresaPorId(id_empresa)));
        repositoryFormulario.save(novaRespService.novoFormulario(encontraFormPorId(id_formulario), encontraEmpresaPorId(id_empresa)));
        List<Pergunta> perguntas = encontraPerguntasPeloFormId(id_formulario);
        for (Pergunta pergunta : perguntas){
            repositoryPergunta.save(novaRespService.todasRespostas(pergunta, pegaMaiorForm()));
        }
        return new RedirectView("/executarForm/" + pegaMaiorForm().getId_formulario());
    }
    //Consultas
    public List<Formulario> todosFormularios(){
        return repositoryFormulario.findAll();
    }

    public List<Empresa> todasEmpresas(){
        return repositoryEmpresa.findAll();
    }

    public Formulario encontraFormPorId(Long id){
        return repositoryFormulario.findById(id).orElse(null);
    }

    public Formulario pegaMaiorForm(){
        return repositoryFormulario.consultaMaiorId();
    }

    public Empresa encontraEmpresaPorId(Long id){
        return repositoryEmpresa.findById(id).orElse(null);
    }

    public List<Pergunta> encontraPerguntasPeloFormId(Long idFormulario) {
        return repositoryPergunta.findPerguntasByFormularioId(idFormulario);
    }
}
