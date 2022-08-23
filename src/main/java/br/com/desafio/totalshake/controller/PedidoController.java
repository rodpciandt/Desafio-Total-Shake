package br.com.desafio.totalshake.controller;

import br.com.desafio.totalshake.dto.PedidoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pedido")
public class PedidoController {


    @PostMapping
    public ResponseEntity<?> create(@RequestBody PedidoRequest pedido) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return null;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id) {
        return null;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete() {
        return null;
    }

}
