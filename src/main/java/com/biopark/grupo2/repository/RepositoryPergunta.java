package com.biopark.grupo2.repository;

import com.biopark.grupo2.model.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPergunta extends JpaRepository<Pergunta, Long> {
}
