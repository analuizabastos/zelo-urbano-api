package com.zelourbano.unidade;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unidades")
public class UnidadeController {

    private final UnidadeService service;

    public UnidadeController(UnidadeService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unidade> buscarPorId(@PathVariable Integer id){
        Unidade unidade = service.buscarPorId(id);
        return ResponseEntity.ok(unidade);
    }

    @GetMapping
    public ResponseEntity<List<Unidade>> listarTodos(){
        List<Unidade> unidades = service.listarTodos();
        return ResponseEntity.ok(unidades);
    }
    @GetMapping("/buscar/ativas")
    public ResponseEntity<List<Unidade>> listarAtivas(){
        List<Unidade> unidades = service.listarAtivas();
        return ResponseEntity.ok(unidades);
    }

    @GetMapping("/buscar/comunidade/{id}")
    public ResponseEntity<List<Unidade>> listarPorComunidade(@PathVariable Integer id){
        List<Unidade> unidades = service.listarPorComunidade(id);
        return ResponseEntity.ok(unidades);
    }

    @PostMapping
    public ResponseEntity<Unidade> cadastrar(@RequestBody Unidade unidade){
        Unidade unidadeNova = service.cadastrar(unidade);
        return ResponseEntity.status(201).body(unidadeNova);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Unidade> atualizar(@PathVariable Integer id, @RequestBody Unidade unidade){
        Unidade unidadeAtualizada = service.atualizar(id, unidade);
        return ResponseEntity.ok(unidadeAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Unidade> desativar(@PathVariable Integer id){
        Unidade unidadeDesativada = service.desativar(id);
        return ResponseEntity.ok(unidadeDesativada);
    }
}
