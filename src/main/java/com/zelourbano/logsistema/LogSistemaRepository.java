package com.zelourbano.logsistema;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogSistemaRepository extends JpaRepository<LogSistema, Integer> {
    List<LogSistema> findAllByUsuarioId(Integer idUsuario);
}
