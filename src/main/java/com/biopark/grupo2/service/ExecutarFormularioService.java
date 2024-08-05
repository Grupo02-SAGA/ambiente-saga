package com.biopark.grupo2.service;

import com.biopark.grupo2.DTO.RespostaDTO;
import com.biopark.grupo2.model.*;
import com.biopark.grupo2.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExecutarFormularioService {

    @Autowired
    private BuscaService buscaService;

    @Autowired
    private RepositoryResposta repositoryResposta;

    @Autowired
    private DocumentosService documentosService;

    @Transactional
    public List<Resposta> criarRespostas(RespostaDTO respostaDTO) {

        Formulario formulario = buscaService
                .buscarFormulario(respostaDTO.getId_formulario());
        Certificado certificado = buscaService
                .buscarCertificado(respostaDTO.getId_certificado());
        Empresa empresa = buscaService
                .buscarEmpresa(respostaDTO.getId_empresa());
        List<Pergunta> perguntas = buscaService
                .buscarPerguntas(respostaDTO.getId_perguntas());

        List<Resposta> novaRespostas = perguntas.stream().map(pergunta -> {

            Resposta novaResposta = new Resposta();

            Integer resposta = respostaDTO
                    .getRespostas()
                        .get(pergunta.getId_pergunta());

            novaResposta.setResposta(resposta);
            novaResposta.setId_usuario(respostaDTO.getId_usuario());
            novaResposta.setUltimaMod(LocalDateTime.now());
            novaResposta.setId_pergunta(pergunta.getId_pergunta());
            novaResposta.setFormulario(formulario);
            novaResposta.setEmpresa(empresa);
            novaResposta.setCertificado(certificado);

            if (respostaDTO.getNomeDocumento()
                    != null && !respostaDTO.getNomeDocumento().isEmpty()){
                List<Documentos> salvarDoc = (List<Documentos>) documentosService
                        .salvarDocumento(respostaDTO.getNomeDocumento());

            }

            return novaResposta;

        }).collect(Collectors.toList());

        repositoryResposta.saveAll(novaRespostas);
        formulario.setBase(2);

        return novaRespostas;
    }
}
