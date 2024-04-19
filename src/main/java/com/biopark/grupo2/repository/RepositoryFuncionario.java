package com.biopark.grupo2.repository;

import com.biopark.grupo2.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryFuncionario extends JpaRepository<Funcionario, Long> {
}
