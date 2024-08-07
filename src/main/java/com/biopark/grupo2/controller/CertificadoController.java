package com.biopark.grupo2.controller;

import com.biopark.grupo2.DTO.RespostaDTO;
import com.biopark.grupo2.model.Certificado;
import com.biopark.grupo2.model.Formulario;
import com.biopark.grupo2.repository.RepositoryFormulario;
import com.biopark.grupo2.repository.RepositoryResposta;
import com.biopark.grupo2.service.BuscaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CertificadoController {
    @Autowired
    private RepositoryResposta repositoryResposta;
    @Autowired
    private RepositoryFormulario repositoryFormulario;

    @Autowired
    private BuscaService buscaService;

    @GetMapping("/certificado/{id}")
    public ModelAndView certificados(@PathVariable Long id,
                                     @RequestParam("id_certificado")Long idCertificado){

        ModelAndView modelAndView = new ModelAndView();
        String resultado;
        String cor;
        modelAndView.setViewName("certificado");
        Formulario form = repositoryFormulario.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Form não encontrado com o ID: " + id));
        double media = (repositoryResposta.contaResps(form)*100)/repositoryResposta.contaTodasResps(form);

        if (media > 90){
            resultado = "Muito satisfatório";
            cor = "darkgreen";
        } else if (media > 75 && media < 90){
            resultado = "Satisfatório";
            cor = "green";
        } else {
            resultado = "Pouco satisfatório";
            cor = "yellow";
        }

        Certificado certificadoRespondido = buscaService
                .buscarCertificado(idCertificado);

        certificadoRespondido.setResultado(media);

        modelAndView.addObject("media", media);
        modelAndView.addObject("resultado", resultado);
        modelAndView.addObject("cor", cor);
        return modelAndView;
    }
}
