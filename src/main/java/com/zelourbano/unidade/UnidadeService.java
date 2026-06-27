package com.zelourbano.unidade;

import com.zelourbano.exceptions.RecursoNaoEncontradoException;
import com.zelourbano.statussistema.StatusSistema;
import com.zelourbano.statussistema.StatusSistemaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeService {

    private final UnidadeRepository repository;
    private final StatusSistemaService statusSistema;

    public UnidadeService(UnidadeRepository repository, StatusSistemaService statusSistema) {
        this.repository = repository;
        this.statusSistema = statusSistema;
    }

    public Unidade buscarPorId(Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Unidade não encontrado"));
    }

    public List<Unidade> listarTodos() {
        return repository.findAll();
    }

    public List<Unidade> listarAtivas() {
        return repository.findAllByStatusNome("Ativo");
    }

    public List<Unidade> listarPorComunidade(Integer idComunidade) {
        return repository.findAllByComunidadeId(idComunidade);
    }

    public Unidade cadastrar(Unidade unidade){
        StatusSistema ativo = statusSistema.buscarPorNome("Ativo");
        unidade.setStatus(ativo);
        return repository.save(unidade);
    }

    public Unidade atualizar(Integer id, Unidade unidadeAtualizada){
        Unidade unidadeAtual = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Unidade não encontrado"));
        unidadeAtual.setLatitude(unidadeAtualizada.getLatitude());
        unidadeAtual.setLongitude(unidadeAtualizada.getLongitude());
        unidadeAtual.setAreaLote(unidadeAtualizada.getAreaLote());
        return repository.save(unidadeAtual);
    }

    public Unidade desativar(Integer id) {
        Unidade unidade = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Unidade não encontrado"));
        StatusSistema inativo = statusSistema.buscarPorNome("Inativo");
        unidade.setStatus(inativo);
        return repository.save(unidade);
    }

}
