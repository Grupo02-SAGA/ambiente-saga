package com.biopark.grupo2.controller;

import com.biopark.grupo2.model.Empresa;
import com.biopark.grupo2.repository.RepositoryEmpresa;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class EmpresaController {

    @Autowired
    private RepositoryEmpresa repositoryEmpresa;

    @GetMapping("/listaEmpresas")
    public ModelAndView listaEmpresas(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "5") int size,
                                      @RequestParam(defaultValue = "all") String filter){
        List<Empresa> empresas = listarEmpresas();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("listaEmpresas");
        modelAndView.addObject("empresas", empresas);
        return modelAndView;
    }

    public List<Empresa> listarEmpresas() {
        return repositoryEmpresa.findAll();
    }

    @GetMapping("/novaEmpresa")
    public ModelAndView modelAndView(){
        Empresa empresa = new Empresa();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("novaEmpresa");
        modelAndView.addObject("empresa", empresa);
        return modelAndView;
    }


    @PostMapping("/novaEmpresa")
    public RedirectView createEmpresa(@ModelAttribute ("empresa") Empresa empresa, RedirectAttributes attributes) {
        repositoryEmpresa.save(empresa);
        attributes.addFlashAttribute("condition", "cadastro-ok");
        return new RedirectView("/novaEmpresa");
    }

    @GetMapping("/editarEmpresa/{id}")
    public ModelAndView getEmpresaById(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editarEmpresa"); // Defina o nome da sua página de detalhes da empresa
        // Buscar empresa pelo ID
        Empresa empresa = repositoryEmpresa.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Empresa não encontrada com o ID: " + id));
        // Adicionar a empresa ao modelo
        modelAndView.addObject("empresa", empresa);
        return modelAndView;
    }

    @PostMapping("/editarEmpresa")
    public RedirectView editarEmpresa(@ModelAttribute("empresa") Empresa empresa, RedirectAttributes attributes) {
        // Carregar a empresa existente do banco de dados
        Empresa empresaExistente = repositoryEmpresa.findById(empresa.getId_empresa())
                .orElseThrow(() -> new IllegalArgumentException("Empresa não encontrada com o ID: " + empresa.getId_empresa()));
        BeanUtils.copyProperties(empresa, empresaExistente, "id_empresa");
        // Salvar a empresa atualizada no banco de dados
        repositoryEmpresa.save(empresaExistente);
        attributes.addFlashAttribute("condition", "cadastro-ok");
        return new RedirectView("/editarEmpresa/" + empresa.getId_empresa());
    }

}
