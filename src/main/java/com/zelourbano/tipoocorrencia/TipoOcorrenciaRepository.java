package com.zelourbano.tipoocorrencia;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface TipoOcorrenciaRepository extends JpaRepository<TipoOcorrencia, Integer> {
    Optional<TipoOcorrencia> findByTipo(String tipo);
}
