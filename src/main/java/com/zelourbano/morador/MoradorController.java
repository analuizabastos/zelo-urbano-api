package com.zelourbano.morador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/moradores")
public class MoradorController {

    private final MoradorService service;

    public MoradorController(MoradorService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Morador> buscarPorId(@PathVariable Integer id){
        Morador morador = service.buscarPorId(id);
        return ResponseEntity.ok(morador);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Morador> buscarPorCpf(@RequestParam String cpf){
        Morador morador = service.buscarPorCpf(cpf);
        return ResponseEntity.ok(morador);
    }

    @GetMapping
    public ResponseEntity<List<Morador>> listarTodos(){
        List<Morador> moradores = service.listarTodos();
        return ResponseEntity.ok(moradores);
    }

    @PostMapping
    public ResponseEntity<Morador> cadastrar(@RequestBody CadastroMoradorRequest request) {
        Morador moradorNovo = service.cadastrar(request.getMorador(), request.getSenha());
        return ResponseEntity.status(201).body(moradorNovo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Morador> atualizar(@PathVariable Integer id, @RequestBody Morador moradorAtual){
        Morador moradorAtualizado = service.atualizar(id, moradorAtual);
        return ResponseEntity.ok(moradorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Morador> desativar(@PathVariable Integer id){
        Morador moradorDesativado = service.desativar(id);
        return ResponseEntity.ok(moradorDesativado);
    }

}
