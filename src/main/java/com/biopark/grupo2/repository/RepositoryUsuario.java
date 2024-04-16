package com.biopark.grupo2.repository;

import com.biopark.grupo2.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUsuario extends JpaRepository<Usuario, Long> {
}
