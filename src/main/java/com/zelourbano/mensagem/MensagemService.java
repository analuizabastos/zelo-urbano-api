package com.zelourbano.mensagem;

import com.zelourbano.exceptions.RecursoNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MensagemService {

    private final MensagemRepository repository;

    public MensagemService(MensagemRepository repository) {
        this.repository = repository;
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
        return repository.save(mensagem);
    }
}