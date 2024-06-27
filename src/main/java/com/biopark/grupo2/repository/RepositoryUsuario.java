package com.biopark.grupo2.repository;

import com.biopark.grupo2.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryUsuario extends JpaRepository<Usuario, Long> {
    //Busca o usuário pelo e-mail e pela senha para efetuar o login.
    Optional<Usuario> findByEmailAndSenha(String email, String senha);
    //Busca o e-mail o usuário para que seja realizada a troca da senha.
    Optional<Usuario> findByEmail(String email);
}
