package com.biopark.grupo2.controller;


import com.biopark.grupo2.DTO.AvaliacaoDTO;
import com.biopark.grupo2.service.ServiceCertificado;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ListaAvaliacoes {

    @Autowired
    private ServiceCertificado serviceCertificado;

    @GetMapping("/listaAvaliacoes")
    public ModelAndView lista(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {
        Page<AvaliacaoDTO> certificados = serviceCertificado.listarAvaliacoesPage(page, size);
        // Adicionando a lista de certificados ao ModelAndView
        ModelAndView modelAndView = new ModelAndView("listaAvaliacoes");
        modelAndView.addObject("avaliacoes", certificados);
        modelAndView.addObject("totalPages", certificados.getTotalPages());
        modelAndView.addObject("currentPage", page);

        return modelAndView;
    }
}


//    @GetMapping("/empresa/{empresaId}")
//    public ModelAndView getResultsByEmpresa(@PathVariable Long empresaId) {
//        List<CertificadoDTO> certificados = serviceCertificado.getResultsByEmpresa(empresaId);
//        ModelAndView modelAndView = new ModelAndView("certificados");
//        modelAndView.addObject("certificados", certificados);
//        return modelAndView;
//    }

//    @GetMapping("/details/{id}")
//    public ModelAndView getCertificadoDetails(@PathVariable Long id) {
//        CertificadoDTO certificado = certificadoService.getCustomQueryResults().stream()
//                .filter(c -> c.getId().equals(id))
//                .findFirst()
//                .orElse(null);
//        ModelAndView modelAndView = new ModelAndView("certificado-details");
//        modelAndView.addObject("certificado", certificado);
//        return modelAndView;
//    }

