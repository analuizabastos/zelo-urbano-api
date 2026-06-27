package com.zelourbano.prestador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestadores")
public class PrestadorController {

    private final PrestadorService service;

    public PrestadorController(PrestadorService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestador> buscarPorId(@PathVariable Integer id){
        Prestador prestador = service.buscarPorId(id);
        return ResponseEntity.ok(prestador);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Prestador> buscarPorNome(@RequestParam String nome){
        Prestador prestador = service.buscarPorNome(nome);
        return ResponseEntity.ok(prestador);
    }

    @GetMapping
    public ResponseEntity<List<Prestador>> listarTodos(){
        List<Prestador> prestadores = service.listarTodos();
        return ResponseEntity.ok(prestadores);
    }

    @PostMapping
    public ResponseEntity<Prestador> cadastrar(@RequestBody CadastroPrestadorRequest request){
        Prestador prestadorNovo = service.cadastrar(request.getPrestador(), request.getSenha());
        return ResponseEntity.status(201).body(prestadorNovo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prestador> atualizar(@PathVariable Integer id, @RequestBody Prestador prestadorAtual){
        Prestador prestadorAtualizado = service.atualizar(id, prestadorAtual);
        return ResponseEntity.ok(prestadorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Prestador> desativar(@PathVariable Integer id){
        Prestador prestadorDesativado = service.desativar(id);
        return ResponseEntity.ok(prestadorDesativado);
    }
}
