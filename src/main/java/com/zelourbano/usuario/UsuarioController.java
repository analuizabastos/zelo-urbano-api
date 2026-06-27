package com.zelourbano.usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Integer id){
        Usuario usuario = service.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Usuario> buscarPorLogin(@RequestParam String login){
        Usuario usuario = service.buscarPorLogin(login);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodos(){
        List<Usuario> usuarios = service.listarTodos();
        return ResponseEntity.ok(usuarios);
    }

    @PatchMapping("/{id}/senha")
    public ResponseEntity<Usuario> alterarSenha(@PathVariable Integer id, @RequestBody AlterarSenhaRequest request){
        Usuario usuario = service.alterarSenha(id, request.getSenhaNova());
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> desativar(@PathVariable Integer id){
        Usuario usuario = service.desativar(id);
        return ResponseEntity.ok(usuario);
    }
}
