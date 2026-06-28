package com.zelourbano.camera;

import com.zelourbano.comunidade.Comunidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CameraRepository extends JpaRepository<Camera, Integer> {
    List<Camera> findAllByComunidadeId(Integer idComunidade);
}
