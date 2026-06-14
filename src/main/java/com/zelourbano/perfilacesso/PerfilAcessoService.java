package com.zelourbano.perfilacesso;

import com.zelourbano.exceptions.RecursoNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilAcessoService {

    private final PerfilAcessoRepository repository;

    public PerfilAcessoService(PerfilAcessoRepository repository) {
        this.repository = repository;
    }

    public PerfilAcesso buscarPorId(Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Perfil de acesso não encontrado"));
    }

    public PerfilAcesso buscarPorNome(String nome){
        return repository.findByNome(nome)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Perfil de acesso não encontrado: " + nome));

    }

    public List<PerfilAcesso> listarTodos(){
        return repository.findAll();
    }
}
