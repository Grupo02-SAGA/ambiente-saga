package com.biopark.grupo2.repository;
import com.biopark.grupo2.model.Certificado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryCertificado extends JpaRepository<Certificado, Long> {
    @Query(value = "select  f.base, c.vencimento as data, f.titulo as form, e.fantasia, u.nome as usuario, c.id_certificado as cert " +
            "FROM certificado c " +
            "JOIN empresa e ON e.id_empresa = c.id_empresa " +
            "JOIN formulario f ON c.id_formulario = f.id_formulario " +
            "JOIN resposta r ON r.id_formulario = f.id_formulario " +
            "JOIN usuario u ON r.id_usuario = u.id_usuario ",
            nativeQuery = true)
    List<Object[]> findAvaliacoes();

    @Query(value = "select  f.base, c.vencimento as data, f.titulo as form, e.fantasia, u.nome as usuario, c.id_certificado as cert " +
            "FROM certificado c " +
            "JOIN empresa e ON e.id_empresa = c.id_empresa " +
            "JOIN formulario f ON c.id_formulario = f.id_formulario " +
            "JOIN resposta r ON r.id_formulario = f.id_formulario " +
            "JOIN usuario u ON r.id_usuario = u.id_usuario ",
            nativeQuery = true)
    Page<Object[]> findAvaliacoesPage(Pageable pageable);
}