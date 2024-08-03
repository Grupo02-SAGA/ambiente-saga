package com.biopark.grupo2.controller;

import com.biopark.grupo2.DTO.RespostaDTO;
import com.biopark.grupo2.model.*;
import com.biopark.grupo2.repository.RepositoryCertificado;
import com.biopark.grupo2.repository.RepositoryFormulario;
import com.biopark.grupo2.repository.RepositoryUsuario;
import com.biopark.grupo2.service.DocumentoService;
import com.biopark.grupo2.service.RespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class ExecutarFormularioController {

    @Autowired
    private RepositoryFormulario repositoryFormulario;

    @Autowired
    private RespostaService respostaService;

    @Autowired
    private DocumentoService documentoService;
    @Autowired
    private RepositoryCertificado repositoryCertificado;

    @GetMapping("/executarFormulario/{id}")
    public ModelAndView executarFormulario(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Formulario formulario = repositoryFormulario.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Formulario não encontrado no get com o ID: " + id));

        List<Pergunta> perguntas = formulario.getPerguntas();

        RespostaDTO respostaDTO = new RespostaDTO();
        respostaDTO.setFormulario(formulario);
        respostaDTO.setPerguntas(perguntas);

        modelAndView.setViewName("executarFormulario");
        modelAndView.addObject("resposta", respostaDTO);
        modelAndView.addObject("idFormulario", formulario.getId_formulario());
        modelAndView.addObject("perguntas", perguntas);
        return modelAndView;
    }

    @PostMapping("/executarFormulario")
    public RedirectView salvarResposta(@ModelAttribute("respostaDTO") RespostaDTO respostaDTO,
                                       Long idFormulario,
                                       RedirectAttributes attributes ){

        Formulario formulario = repositoryFormulario.findById(idFormulario)
                .orElseThrow(() -> new IllegalArgumentException("Formulario não encontrado no get com o ID: " + idFormulario));

        Certificado certificado = repositoryCertificado.findById(idFormulario)
                .orElseThrow(() -> new IllegalArgumentException("Certificado não encontrado no get com o ID: " + idFormulario));

        Integer idUsuario = 1;
        Long idCertificado = idFormulario;


        respostaDTO.setId_usuario(idUsuario);
        respostaDTO.setId_certificado(idCertificado);

        List<Pergunta> perguntas = respostaDTO.getPerguntas();

        respostaService.salvarRespostas(perguntas, respostaDTO);

        if(respostaDTO.getNomeDocumento() != null && !respostaDTO
                .getNomeDocumento().isEmpty()){
            String nomeDocumento = respostaDTO.getNomeDocumento();
            documentoService.salvarNomeDocumento(nomeDocumento);
        }

        attributes.addFlashAttribute("resposta-cadastrada",
                "resposta-cadastrada");
        return new RedirectView("/detalhesFormulario/" + idFormulario);
    }
}
