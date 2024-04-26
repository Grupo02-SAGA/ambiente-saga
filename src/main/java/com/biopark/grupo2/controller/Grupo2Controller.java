package com.biopark.grupo2.controller;

import com.biopark.grupo2.model.Formulario;
import com.biopark.grupo2.repository.RepositoryFormulario;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.Optional;

@Controller
public class Grupo2Controller {
    @Autowired
    private RepositoryFormulario repositoryFormulario;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/detalhesDeFormulario/{id}")

    public List<String> getQuestionsByFormId(Long id_formulario) {
        String sql = """
            SELECT p.titulo
            FROM Pergunta p
            INNER JOIN Formulario_pergunta fp
                ON p.id_pergunta = fp.id_pergunta
            WHERE fp.id_formulario = ?
            """;
        return jdbcTemplate.queryForList(sql, String.class, id_formulario);
    }
    private SeuDao seuDao;
    public List<String> getQuestionsByFormularioId(Long id_formulario) {
        return seuDao.getQuestionsByFormId(id_formulario);
    }

    public String exibirCriarMais(@PathVariable Long id, Model model) {
        Optional<Formulario> formularioOpt = repositoryFormulario.findById(id);
        if (formularioOpt.isPresent()) {
            Formulario formulario = formularioOpt.get();
            model.addAttribute("titulo", formulario.getTitulo());
            model.addAttribute("pergunta", getQuestionsByFormularioId(id));
        }
        return "criarMais";
    }
}

