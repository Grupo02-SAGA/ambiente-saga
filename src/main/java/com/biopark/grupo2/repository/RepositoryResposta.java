package com.biopark.grupo2.repository;

import com.biopark.grupo2.model.Formulario;
import com.biopark.grupo2.model.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryResposta extends JpaRepository<Resposta, Long> {
    @Query("SELECT count(r) FROM Resposta r WHERE r.resposta = 0 AND r.id_formulario = :id_formulario")
    int contaResps(@Param("id_formulario") Long id_formulario);

    @Query("SELECT count(r) FROM Resposta r WHERE r.resposta <> 2 AND r.id_formulario = :id_formulario")
    int contaTodasResps(@Param("id_formulario") Long id_formulario);
}
