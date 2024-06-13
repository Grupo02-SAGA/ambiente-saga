package com.biopark.grupo2.repository;

import com.biopark.grupo2.model.Pergunta;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryPergunta extends JpaRepository<Pergunta, Long> {
//    @Query(value = "SELECT p.titulo "
//            + "FROM Pergunta p "
//            + "JOIN Formulario f ON f.id_formulario = p.id_formulario "
//            + "WHERE f.id_formulario = :id_formulario AND p.estado = true", nativeQuery = true)
//    List<String> findTitlesByFormId(@Param("idFormulario") Long idFormulario);

    @Query("SELECT p.titulo FROM Pergunta p WHERE p.id_formulario.id_formulario = :idFormulario AND p.estado = true")
    List<String> findTitlesByFormId(@Param("idFormulario") Long idFormulario);
}