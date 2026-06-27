package com.zelourbano.morador;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MoradorRepository extends JpaRepository<Morador, Integer> {
    Optional<Morador> findByCpf(String cpf);
}
