package com.biopark.grupo2.controller;

import com.biopark.grupo2.DTO.AvaliacaoDTO;
import com.biopark.grupo2.service.ServiceCertificado;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListaAvaliacoes {

    @Autowired
    private ServiceCertificado serviceCertificado;

    @GetMapping("/listaAvaliacoes")
    public ModelAndView lista(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "10") int size,
                              @RequestParam(defaultValue = "all") String filter,
                              @RequestParam(required = false) Integer status) {
        Page<AvaliacaoDTO> certificados = serviceCertificado.listarAvaliacoesPage(page, size, filter, status);
        ModelAndView modelAndView = new ModelAndView("listaAvaliacoes");
        modelAndView.addObject("avaliacoes", certificados);
        modelAndView.addObject("totalPages", certificados.getTotalPages());
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("filter", filter);
        modelAndView.addObject("status", status);
        return modelAndView;
    }
}
