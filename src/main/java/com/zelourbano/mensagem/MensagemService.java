package com.zelourbano.mensagem;

import com.zelourbano.exceptions.RecursoNaoEncontradoException;
import com.zelourbano.logsistema.LogSistemaService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MensagemService {

    private final MensagemRepository repository;
    private final LogSistemaService logSistema;

    public MensagemService(MensagemRepository repository, LogSistemaService logSistema) {
        this.repository = repository;
        this.logSistema = logSistema;
    }

    public Mensagem buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Mensagem não encontrada"));
    }

    public List<Mensagem> listarPorOcorrencia(Integer idOcorrencia) {
        return repository.findAllByOcorrenciaId(idOcorrencia);
    }

    public Mensagem enviar(Mensagem mensagem) {
        mensagem.setDataEnvio(LocalDateTime.now());
        logSistema.registrar(null, "Enviou mensagem na ocorrência id: " + mensagem.getOcorrencia().getId());
        return repository.save(mensagem);
    }
}