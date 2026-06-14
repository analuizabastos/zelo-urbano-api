package com.zelourbano.tipoocorrencia;

import com.zelourbano.exceptions.RecursoNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoOcorrenciaService {

    private final TipoOcorrenciaRepository repository;

    public TipoOcorrenciaService(TipoOcorrenciaRepository repository) {
        this.repository = repository;
    }

    public TipoOcorrencia buscarPorId(Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Tipo de ocorrência não encontrado"));
    }

    public TipoOcorrencia buscarPorTipo(String tipo){
        return repository.findByTipo(tipo)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Tipo de ocorrência não encontrado: " + tipo));
    }

    public List<TipoOcorrencia> listarTodos(){
        return repository.findAll();
    }
}
