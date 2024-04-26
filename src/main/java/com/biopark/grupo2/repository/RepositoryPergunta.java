package com.biopark.grupo2.repository;

import com.biopark.grupo2.model.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryPergunta extends JpaRepository<Pergunta, Long> {
    @Query("SELECT p.titulo FROM Pergunta p "
            + "INNER JOIN Formulario_pergunta fp ON p.id_pergunta = fp.id_pergunta "
            + "WHERE fp.id_formulario = :idFormulario")
    List<String> findTitlesByFormId(@Param("idFormulario") Long idFormulario);
}
