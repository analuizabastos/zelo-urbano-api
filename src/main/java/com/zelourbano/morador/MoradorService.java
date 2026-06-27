package com.zelourbano.morador;

import com.zelourbano.exceptions.RecursoNaoEncontradoException;
import com.zelourbano.statussistema.StatusSistema;
import com.zelourbano.statussistema.StatusSistemaService;
import com.zelourbano.usuario.Usuario;
import com.zelourbano.usuario.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoradorService {

    private final MoradorRepository repository;
    private final StatusSistemaService statusSistema;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public MoradorService(MoradorRepository repository, StatusSistemaService statusSistema, UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.statusSistema = statusSistema;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Morador buscarPorId(Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Morador não encontrado"));
    }

    public Morador buscarPorCpf(String cpf){
        return repository.findByCpf(cpf)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Morador não encontrado"));
    }

    public List<Morador> listarTodos(){
        return repository.findAll();
    }

    public Morador cadastrar(Morador morador, String senha) {
        StatusSistema ativo = statusSistema.buscarPorNome("Ativo");
        morador.setStatus(ativo);
        Morador moradorSalvo = repository.save(morador);

        Usuario usuario = new Usuario();
        usuario.setLogin(morador.getEmail());
        usuario.setSenha(passwordEncoder.encode(senha));
        usuario.setMorador(moradorSalvo);
        usuario.setStatus(ativo);

        usuarioRepository.save(usuario);
        return moradorSalvo;
    }

    public Morador atualizar(Integer id, Morador moradorAtualizado){
         Morador moradorAtual = repository.findById(id)
                 .orElseThrow(() -> new RecursoNaoEncontradoException("Morador não encontrado"));
        moradorAtual.setNome(moradorAtualizado.getNome());
        if (!moradorAtual.getEmail().equals(moradorAtualizado.getEmail())) {
            usuarioRepository.findByMoradorId(id).ifPresent(usuario -> {
                usuario.setLogin(moradorAtualizado.getEmail());
                usuarioRepository.save(usuario);
            });}
        moradorAtual.setEmail(moradorAtualizado.getEmail());
        moradorAtual.setTelefone(moradorAtualizado.getTelefone());
        moradorAtual.setLogradouro(moradorAtualizado.getLogradouro());
        moradorAtual.setCep(moradorAtualizado.getCep());
        moradorAtual.setNumero(moradorAtualizado.getNumero());
        moradorAtual.setBairro(moradorAtualizado.getBairro());
        moradorAtual.setCidade(moradorAtualizado.getCidade());
        moradorAtual.setEstado(moradorAtualizado.getEstado());
        moradorAtual.setComplemento(moradorAtualizado.getComplemento());
        moradorAtual.setDataNascimento(moradorAtualizado.getDataNascimento());
        moradorAtual.setObservacoes(moradorAtualizado.getObservacoes());
        moradorAtual.setDocumentoIdentificacao(moradorAtualizado.getDocumentoIdentificacao());
         return repository.save(moradorAtual);
    }

    public Morador desativar(Integer id){
        Morador moradorAtual = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Morador não encontrado"));
        StatusSistema inativo = statusSistema.buscarPorNome("Inativo");
        moradorAtual.setStatus(inativo);
        usuarioRepository.findByMoradorId(id).ifPresent(usuario -> {
            usuario.setStatus(inativo);
            usuarioRepository.save(usuario);
        });
        return repository.save(moradorAtual);
    }
}
