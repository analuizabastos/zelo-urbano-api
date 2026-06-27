package com.zelourbano.comunidade;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comunidades")
public class ComunidadeController {

    private final ComunidadeService service;

    public ComunidadeController(ComunidadeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Comunidade>> listarTodos(){
        List<Comunidade> comunidades = service.listarTodos();
        return ResponseEntity.ok(comunidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comunidade> buscarPorId(@PathVariable Integer id){
        Comunidade comunidade = service.buscarPorId(id);
        return ResponseEntity.ok(comunidade);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Comunidade> buscarPorNome(@RequestParam String nome){
        Comunidade comunidade = service.buscarPorNome(nome);
        return ResponseEntity.ok(comunidade);
    }

    @PostMapping
    public ResponseEntity<Comunidade> cadastrar(@RequestBody Comunidade comunidade){
        Comunidade nova = service.cadastrar(comunidade);
        return ResponseEntity.status(201).body(nova);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comunidade> atualizar(@PathVariable Integer id, @RequestBody Comunidade comunidade){
        Comunidade comunidadeAtualizada = service.atualizar(id, comunidade);
        return ResponseEntity.ok(comunidadeAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Comunidade> desativar(@PathVariable Integer id){
        Comunidade comunidadeDesativada = service.desativar(id);
        return ResponseEntity.ok(comunidadeDesativada);
    }
}
