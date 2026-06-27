package com.zelourbano.prestador;

import com.zelourbano.exceptions.RecursoNaoEncontradoException;
import com.zelourbano.statussistema.StatusSistema;
import com.zelourbano.statussistema.StatusSistemaService;
import com.zelourbano.usuario.Usuario;
import com.zelourbano.usuario.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestadorService {

    private final PrestadorRepository repository;
    private final StatusSistemaService statusSistema;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public PrestadorService(PrestadorRepository repository, StatusSistemaService statusSistema, UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.statusSistema = statusSistema;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Prestador buscarPorId(Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Prestador não encontrado"));
    }

    public Prestador buscarPorNome(String nome){
        return repository.findByNome(nome)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Prestador não encontrado"));
    }

    public List<Prestador> listarTodos(){
        return repository.findAll();
    }

    public Prestador cadastrar(Prestador prestador, String senha){
        StatusSistema ativo = statusSistema.buscarPorNome("Ativo");
        prestador.setStatus(ativo);
        Prestador prestadorNovo = repository.save(prestador);

        Usuario usuario = new Usuario();
        usuario.setLogin(prestador.getEmail());
        usuario.setSenha(passwordEncoder.encode(senha));
        usuario.setPrestador(prestadorNovo);
        usuario.setStatus(ativo);

        usuarioRepository.save(usuario);
        return prestadorNovo;
    }

    public Prestador atualizar(Integer id, Prestador prestadorAtualizado){
        Prestador prestadorAtual = repository.findById(id)
                .orElseThrow(()-> new RecursoNaoEncontradoException("Prestador não encontrado"));
        prestadorAtual.setNome(prestadorAtualizado.getNome());
        if (!prestadorAtual.getEmail().equals(prestadorAtualizado.getEmail())) {
            usuarioRepository.findByMoradorId(id).ifPresent(usuario -> {
                usuario.setLogin(prestadorAtualizado.getEmail());
                usuarioRepository.save(usuario);
            });}
        prestadorAtual.setEmail(prestadorAtualizado.getEmail());
        prestadorAtual.setTelefone(prestadorAtualizado.getTelefone());
        prestadorAtual.setCategoriaDeServico(prestadorAtualizado.getCategoriaDeServico());
        prestadorAtual.setLinkSuporte(prestadorAtualizado.getLinkSuporte());
        prestadorAtual.setObservacoes(prestadorAtualizado.getObservacoes());
        return repository.save(prestadorAtual);
    }

    public Prestador desativar(Integer id){
        Prestador prestadorDesativado = repository.findById(id)
                .orElseThrow(()-> new RecursoNaoEncontradoException("Prestador não encontrado"));
        StatusSistema inativo = statusSistema.buscarPorNome("Inativo");
        prestadorDesativado.setStatus(inativo);

        usuarioRepository.findByPrestadorId(id).ifPresent(usuario -> {
            usuario.setStatus(inativo);
            usuarioRepository.save(usuario);
        });
        return repository.save(prestadorDesativado);
    }
}
