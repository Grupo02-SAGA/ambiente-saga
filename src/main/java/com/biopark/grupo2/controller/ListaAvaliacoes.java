package com.biopark.grupo2.controller;


import com.biopark.grupo2.DTO.CertificadoDTO;
import com.biopark.grupo2.service.ServiceCertificado;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
public class ListaAvaliacoes {

    @Autowired
    private ServiceCertificado serviceCertificado;

//    @GetMapping("/avaliacoes")
//    public String lista(Model model) {
//        List<Object[]> certificados = serviceCertificado.listarAvaliacoes();
//        model.addAttribute("avaliacoes", certificados);
//        return "avaliacoes";
//    }



    @GetMapping("/avaliacoes")
    public ModelAndView lista() {
        List<CertificadoDTO> certificados = serviceCertificado.listarAvaliacoes();

        // Adicionando a lista de certificados ao ModelAndView
        ModelAndView modelAndView = new ModelAndView("avaliacoes");
        modelAndView.addObject("avaliacoes", certificados);

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

