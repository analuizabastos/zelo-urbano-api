package com.zelourbano.ocorrencia;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ocorrencias")
public class OcorrenciaController {

    private final OcorrenciaService service;

    public OcorrenciaController(OcorrenciaService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ocorrencia> buscarPorId(@PathVariable Integer id){
        Ocorrencia ocorrencia = service.buscarPorId(id);
        return ResponseEntity.ok(ocorrencia);
    }

    @GetMapping
    public ResponseEntity<List<Ocorrencia>> listarTodos(){
        List<Ocorrencia> ocorrencias = service.listarTodos();
        return ResponseEntity.ok(ocorrencias);
    }

    @GetMapping("/buscar/autor/{id}")
    public ResponseEntity<List<Ocorrencia>> listarPorUsuarioAutor(@PathVariable Integer id){
        List<Ocorrencia> ocorrencias = service.listarPorUsuarioAutor(id);
        return ResponseEntity.ok(ocorrencias);
    }

    @PostMapping
    public ResponseEntity<Ocorrencia> criarOcorrencia(@RequestBody Ocorrencia ocorrencia){
        Ocorrencia ocorrenciaNova = service.criar(ocorrencia);
        return ResponseEntity.status(201).body(ocorrenciaNova);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ocorrencia> atualizar(@PathVariable Integer id, @RequestBody Ocorrencia ocorrencia){
        Ocorrencia ocorrenciaAtualizada = service.atualizar(id, ocorrencia);
        return ResponseEntity.ok(ocorrenciaAtualizada);
    }

    @PatchMapping("/{id}/concluir")
    public ResponseEntity<Ocorrencia> concluirOcorrencia(@PathVariable Integer id){
        Ocorrencia ocorrencia = service.concluir(id);
        return ResponseEntity.ok(ocorrencia);
    }
}
