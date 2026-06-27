package com.zelourbano.usuario;

import com.zelourbano.exceptions.RecursoNaoEncontradoException;
import com.zelourbano.statussistema.StatusSistemaService;
import com.zelourbano.statussistema.StatusSistema;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final StatusSistemaService statusSistema;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repository, StatusSistemaService statusSistema, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.statusSistema = statusSistema;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario buscarPorId(Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuario não encontrado"));
    }
    public Usuario buscarPorLogin(String login){
        return repository.findByLogin(login)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuario não encontrado"));
    }

    public List<Usuario> listarTodos(){
        return repository.findAll();
    }

    public Usuario alterarSenha(Integer id, String novaSenha) {
        Usuario usuarioAtual = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuario não encontrado"));
        usuarioAtual.setSenha(passwordEncoder.encode(novaSenha));
        return repository.save(usuarioAtual);
    }

    public Usuario desativar(Integer id){
        Usuario usuarioAtual = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuario não encontrado"));
        StatusSistema inativo = statusSistema.buscarPorNome("Inativo");
        usuarioAtual.setStatus(inativo);
        return repository.save(usuarioAtual);
    }
}
