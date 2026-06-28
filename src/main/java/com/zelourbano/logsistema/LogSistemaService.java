package com.zelourbano.logsistema;

import com.zelourbano.usuario.Usuario;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogSistemaService {

    private final LogSistemaRepository repository;

    public LogSistemaService(LogSistemaRepository repository) {
        this.repository = repository;
    }

    public void registrar(Usuario usuario, String operacao) {
        LogSistema log = new LogSistema();
        log.setUsuario(usuario);
        log.setOperacao(operacao);
        log.setDataHora(LocalDateTime.now());
        repository.save(log);
    }

    public List<LogSistema> listarTodos() {
        return repository.findAll();
    }

    public List<LogSistema> listarPorUsuario(Integer idUsuario) {
        return repository.findAllByUsuarioId(idUsuario);
    }
}