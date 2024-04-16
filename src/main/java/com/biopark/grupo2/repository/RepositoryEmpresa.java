package com.biopark.grupo2.repository;

import com.biopark.grupo2.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryEmpresa extends JpaRepository<Empresa, Long> {
}
