package com.biopark.grupo2.repository;

import com.biopark.grupo2.model.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryFormulario extends JpaRepository<Formulario, Long> {
}
