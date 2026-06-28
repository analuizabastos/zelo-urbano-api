package com.zelourbano.camera;

import com.zelourbano.exceptions.RecursoNaoEncontradoException;
import com.zelourbano.logsistema.LogSistemaService;
import com.zelourbano.statussistema.StatusSistema;
import com.zelourbano.statussistema.StatusSistemaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CameraService {

    private final CameraRepository repository;
    private final StatusSistemaService statusSistema;
    private final LogSistemaService logSistema;

    public CameraService(CameraRepository repository, StatusSistemaService statusSistema, LogSistemaService logSistema) {
        this.repository = repository;
        this.statusSistema = statusSistema;
        this.logSistema = logSistema;
    }

    public Camera buscarPorId(Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Camera não encontrada"));
    }

    public List<Camera> listarTodos(){
        return repository.findAll();
    }

    public List<Camera> listarPorComunidade(Integer idComunidade){
        return repository.findAllByComunidadeId(idComunidade);
    }

    public Camera cadastrar(Camera camera){
        StatusSistema ativo = statusSistema.buscarPorNome("Ativo");
        camera.setStatus(ativo);
        logSistema.registrar(null, "Cadastrou câmera: " + camera.getDescricao());
        return repository.save(camera);
    }

    public Camera atualizar(Integer id, Camera cameraAtualizada){
        Camera cameraAtual = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Camera não encontrada"));
        cameraAtual.setDescricao(cameraAtualizada.getDescricao());
        cameraAtual.setLatitude(cameraAtualizada.getLatitude());
        cameraAtual.setLongitude(cameraAtualizada.getLongitude());
        cameraAtual.setLinkRtspUrl(cameraAtualizada.getLinkRtspUrl());
        cameraAtual.setOrigemMorador(cameraAtualizada.getOrigemMorador());
        return repository.save(cameraAtual);
    }

    public void deletar(Integer id){
        Camera cameraDeletada = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Camera não encontrada"));
        logSistema.registrar(null, "Deletou câmera id: " + id);
        repository.delete(cameraDeletada);
    }
}
