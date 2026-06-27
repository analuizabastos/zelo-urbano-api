package com.zelourbano.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByLogin(String nome);
    Optional<Usuario> findByMoradorId(Integer idMorador);
    Optional<Usuario> findByPrestadorId(Integer idPrestador);
}
