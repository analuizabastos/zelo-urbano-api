package com.zelourbano.unidade;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UnidadeRepository extends JpaRepository<Unidade, Integer> {
    List<Unidade> findAllByStatusNome(String nome);

    List<Unidade> findAllByComunidadeId(Integer idComunidade);

}
