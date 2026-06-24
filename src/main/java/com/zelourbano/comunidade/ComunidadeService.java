package com.zelourbano.comunidade;

import com.zelourbano.exceptions.RecursoNaoEncontradoException;
import com.zelourbano.statussistema.StatusSistema;
import com.zelourbano.statussistema.StatusSistemaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComunidadeService {

    private final ComunidadeRepository repository;
    private final StatusSistemaService statusSistema;

    public ComunidadeService(ComunidadeRepository repository, StatusSistemaService statusSistema) {
        this.repository = repository;
        this.statusSistema = statusSistema;
    }

    public Comunidade buscarPorId(Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Comunidade não encontrada"));
    }

    public Comunidade buscarPorNome(String nome){
        return repository.findByNome(nome)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Comunidade não encontrada: " + nome));
    }

    public List<Comunidade> listarTodos() {
        return repository.findAll();
    }

    public Comunidade cadastrar(Comunidade comunidade){
        StatusSistema ativo = statusSistema.buscarPorNome("Ativo");
        comunidade.setStatus(ativo);
        return repository.save(comunidade);
    }

    public Comunidade atualizar(Integer id, Comunidade comunidadeAtualizada) {
        Comunidade comunidadeAtual = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Comunidade não encontrada"));
        comunidadeAtual.setNome(comunidadeAtualizada.getNome());
        comunidadeAtual.setCnpj(comunidadeAtualizada.getCnpj());
        comunidadeAtual.setRazaoSocial(comunidadeAtualizada.getRazaoSocial());
        comunidadeAtual.setNomeFantasia(comunidadeAtualizada.getNomeFantasia());
        comunidadeAtual.setInscricaoEstadual(comunidadeAtualizada.getInscricaoEstadual());
        comunidadeAtual.setEmail(comunidadeAtualizada.getEmail());
        comunidadeAtual.setAreaTotal(comunidadeAtualizada.getAreaTotal());
        comunidadeAtual.setObservacoes(comunidadeAtualizada.getObservacoes());
        comunidadeAtual.setDocIdentificacao(comunidadeAtualizada.getDocIdentificacao());
        return repository.save(comunidadeAtual);
    }

    public Comunidade desativar(Integer id){
        Comunidade comunidade = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Comunidade não encontrada"));
        StatusSistema inativo = statusSistema.buscarPorNome("Inativo");
        comunidade.setStatus(inativo);
        return repository.save(comunidade);
    }
}
