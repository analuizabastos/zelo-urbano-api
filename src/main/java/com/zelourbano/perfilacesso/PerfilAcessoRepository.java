package com.zelourbano.perfilacesso;

import com.zelourbano.statussistema.StatusSistema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerfilAcessoRepository extends JpaRepository<PerfilAcesso, Integer> {
    Optional<PerfilAcesso> findByNome(String nome);
}
