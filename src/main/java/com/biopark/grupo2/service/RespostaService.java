package com.biopark.grupo2.service;

import com.biopark.grupo2.DTO.RespostaDTO;
import com.biopark.grupo2.model.Formulario;
import com.biopark.grupo2.model.Pergunta;
import com.biopark.grupo2.model.Resposta;
import com.biopark.grupo2.model.Usuario;
import com.biopark.grupo2.repository.RepositoryFormulario;
import com.biopark.grupo2.repository.RepositoryPergunta;
import com.biopark.grupo2.repository.RepositoryResposta;
import com.biopark.grupo2.repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class RespostaService {

    @Autowired
    private RepositoryResposta repositoryResposta;

    @Autowired
    private RepositoryFormulario formularioRepository;

    @Autowired
    private RepositoryPergunta perguntaRepository;

    @Transactional
    public void salvarRespostas(List<Pergunta> perguntas, RespostaDTO respostaDTO) {
        Formulario formulario = formularioRepository.findById(respostaDTO.getFormulario().getId_formulario())
                .orElseThrow(() -> new IllegalArgumentException("Formulario não encontrado com o ID: " + respostaDTO.getFormulario().getId_formulario()));


        if (perguntas != null) {
            for (Pergunta pergunta : perguntas) {
                Pergunta perguntaPersistida = perguntaRepository.findById(pergunta.getId_pergunta())
                        .orElseThrow(() -> new IllegalArgumentException("Pergunta não encontrada com o ID: " + pergunta.getId_pergunta()));

                Resposta novaResposta = new Resposta();
                novaResposta.setResposta(respostaDTO.getResposta());
                novaResposta.setId_pergunta(perguntaPersistida);
                novaResposta.setId_formulario(formulario);
                novaResposta.setId_usuario(1);

                repositoryResposta.save(novaResposta);
            }
        } else {
            throw new IllegalArgumentException("Lista de perguntas não pode ser nula");
        }
    }
}
