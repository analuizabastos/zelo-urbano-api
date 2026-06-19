package com.zelourbano.comunidade;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComunidadeRepository extends JpaRepository<Comunidade, Integer> {
    Optional<Comunidade> findByNome(String nome);
}
