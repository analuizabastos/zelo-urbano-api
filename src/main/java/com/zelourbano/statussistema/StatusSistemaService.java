package com.zelourbano.statussistema;

import com.zelourbano.exceptions.RecursoNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusSistemaService {

    private final StatusSistemaRepository repository;

    public StatusSistemaService(StatusSistemaRepository repository) {
        this.repository = repository;
    }

    public StatusSistema buscarPorId(Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Status não encontrado"));
    }

    public StatusSistema buscarPorNome(String nome){
        return repository.findByNome(nome)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Status não encontrado: " + nome));
    }

    public List<StatusSistema> listarTodos(){
        return repository.findAll();
    }
}
