package com.biopark.grupo2.repository;

import com.biopark.grupo2.model.Pergunta;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryPergunta extends JpaRepository<Pergunta, Long> {
    @Query(value = "SELECT p.titulo"
            + "FROM Pergunta p "
            + "JOIN Formulario_pergunta fp ON p.id_pergunta = fp.id_pergunta "
            + "WHERE fp.id_formulario = :idFormulario AND p.estado = true", nativeQuery = true)
    List<String> findTitlesByFormId(@Param("idFormulario") Long idFormulario);
    @Transactional
    @Modifying
    @Query(value = "UPDATE pergunta p SET p.estado = false WHERE p.id_pergunta = :perguntaId")
    void atualizarAtivoPorId(@Param("perguntaId")Long perguntaId);
}
