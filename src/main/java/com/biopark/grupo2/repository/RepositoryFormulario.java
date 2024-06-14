package com.biopark.grupo2.repository;
import com.biopark.grupo2.model.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryFormulario extends JpaRepository<Formulario, Long> {
    @Query("SELECT p FROM Formulario p WHERE p.id_formulario = (SELECT MAX(p2.id_formulario) FROM Formulario p2)")
    Formulario consultaMaiorId();

    @Query("SELECT id_formulario,titulo,base,estado FROM Formulario WHERE base = 0")
    List<Formulario> consultaTodosOsBase();
}
