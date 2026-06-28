package com.zelourbano.mensagem;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MensagemRepository extends JpaRepository<Mensagem, Integer> {
    List<Mensagem> findAllByOcorrenciaId(Integer idOcorrencia);
}
