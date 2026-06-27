package com.zelourbano.prestador;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrestadorRepository extends JpaRepository<Prestador, Integer> {
    Optional<Prestador> findByNome(String nome);
}
