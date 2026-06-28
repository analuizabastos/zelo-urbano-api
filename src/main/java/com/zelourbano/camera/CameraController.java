package com.zelourbano.camera;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cameras")
public class CameraController {

    private final CameraService service;

    public CameraController(CameraService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Camera> buscarPorId(@PathVariable Integer id){
        Camera camera = service.buscarPorId(id);
        return ResponseEntity.ok(camera);
    }

    @GetMapping
    public ResponseEntity<List<Camera>> listarTodos(){
        List<Camera> cameras = service.listarTodos();
        return ResponseEntity.ok(cameras);
    }

    @GetMapping("/buscar/comunidade/{idComunidade}")
    public ResponseEntity<List<Camera>> listarPorComunidade(@PathVariable Integer idComunidade){
        List<Camera> cameras = service.listarPorComunidade(idComunidade);
        return ResponseEntity.ok(cameras);
    }

    @PostMapping
    public ResponseEntity<Camera> cadastrar(@RequestBody Camera camera){
        Camera cameraNova = service.cadastrar(camera);
        return ResponseEntity.status(201).body(cameraNova);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Camera> atualizar(@PathVariable Integer id, @RequestBody Camera camera){
        Camera cameraAtualizada = service.atualizar(id, camera);
        return ResponseEntity.ok(cameraAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
