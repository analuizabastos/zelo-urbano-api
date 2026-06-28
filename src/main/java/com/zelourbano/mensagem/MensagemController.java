package com.zelourbano.mensagem;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mensagens")
public class MensagemController {

    private final MensagemService service;

    public MensagemController(MensagemService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mensagem> buscarPorId(@PathVariable Integer id) {
        Mensagem mensagem = service.buscarPorId(id);
        return ResponseEntity.ok(mensagem);
    }

    @GetMapping("/ocorrencia/{idOcorrencia}")
    public ResponseEntity<List<Mensagem>> listarPorOcorrencia(@PathVariable Integer idOcorrencia) {
        List<Mensagem> mensagens = service.listarPorOcorrencia(idOcorrencia);
        return ResponseEntity.ok(mensagens);
    }

    @PostMapping
    public ResponseEntity<Mensagem> enviar(@RequestBody Mensagem mensagem) {
        Mensagem mensagemEnviada = service.enviar(mensagem);
        return ResponseEntity.status(201).body(mensagemEnviada);
    }
}