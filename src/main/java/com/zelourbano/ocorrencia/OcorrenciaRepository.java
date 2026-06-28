package com.zelourbano.ocorrencia;

import com.zelourbano.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Integer> {
    List<Ocorrencia> findAllByUsuarioAutorId(Integer id);
}
