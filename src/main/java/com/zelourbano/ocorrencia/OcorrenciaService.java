package com.zelourbano.ocorrencia;

import com.zelourbano.exceptions.RecursoNaoEncontradoException;
import com.zelourbano.logsistema.LogSistemaService;
import com.zelourbano.statussistema.StatusSistema;
import com.zelourbano.statussistema.StatusSistemaService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class OcorrenciaService {

    private final OcorrenciaRepository repository;
    private final StatusSistemaService statusSistema;
    private final LogSistemaService logSistema;

    public OcorrenciaService(OcorrenciaRepository repository, StatusSistemaService statusSistema, LogSistemaService logSistema) {
        this.repository = repository;
        this.statusSistema = statusSistema;
        this.logSistema = logSistema;
    }

    public Ocorrencia buscarPorId(Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Ocorrencia nao encontrada"));
    }

    public List<Ocorrencia> listarPorUsuarioAutor(Integer idUsuarioAutor){
        return repository.findAllByUsuarioAutorId(idUsuarioAutor);
    }

    public List<Ocorrencia> listarTodos(){
        return repository.findAll();
    }

    public Ocorrencia criar(Ocorrencia ocorrencia){
        StatusSistema aberta = statusSistema.buscarPorNome("Aberta");
        ocorrencia.setStatus(aberta);
        ocorrencia.setDataDoRegistro(LocalDateTime.now());
        ocorrencia.setProtocolo(gerarProtocolo());
        logSistema.registrar(null, "Criou ocorrência " + ocorrencia.getProtocolo());
        return repository.save(ocorrencia);
    }

    public Ocorrencia atualizar(Integer id, Ocorrencia ocorrenciaAtualizada){
        Ocorrencia ocorrenciaAtual = repository.findById(id)
                        .orElseThrow(() -> new RecursoNaoEncontradoException("Ocorrencia nao encontrada"));
        ocorrenciaAtual.setTitulo(ocorrenciaAtualizada.getTitulo());
        ocorrenciaAtual.setDescricao(ocorrenciaAtualizada.getDescricao());
        ocorrenciaAtual.setMidia(ocorrenciaAtualizada.getMidia());
        ocorrenciaAtual.setLatitude(ocorrenciaAtualizada.getLatitude());
        ocorrenciaAtual.setLongitude(ocorrenciaAtualizada.getLongitude());
        ocorrenciaAtual.setDenunciaAnonima(ocorrenciaAtualizada.getDenunciaAnonima());
        ocorrenciaAtual.setTipoOcorrencia(ocorrenciaAtualizada.getTipoOcorrencia());
        ocorrenciaAtual.setCamera(ocorrenciaAtualizada.getCamera());
        ocorrenciaAtual.setPrestador(ocorrenciaAtualizada.getPrestador());
        ocorrenciaAtual.setUsuarioDestino(ocorrenciaAtualizada.getUsuarioDestino());
        return repository.save(ocorrenciaAtual);
    }

    public Ocorrencia concluir(Integer id){
        Ocorrencia ocorrenciaConcluida = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Ocorrencia nao encontrada"));
        StatusSistema concluida = statusSistema.buscarPorNome("Concluida");
        ocorrenciaConcluida.setStatus(concluida);
        logSistema.registrar(null, "Concluiu ocorrência: " + ocorrenciaConcluida.getProtocolo());
        return repository.save(ocorrenciaConcluida);
    }

    private String gerarProtocolo() {
        String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        long count = repository.count() + 1;
        return data + String.format("%04d", count);
    }
}
