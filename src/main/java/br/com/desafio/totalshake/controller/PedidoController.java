package br.com.desafio.totalshake.controller;

import br.com.desafio.totalshake.dto.PedidoDTO;
import br.com.desafio.totalshake.enums.Status;
import br.com.desafio.totalshake.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;


    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody PedidoDTO pedido) {
        var pedidoResponse = this.pedidoService.create(pedido);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{idPedido}")
                .buildAndExpand(pedidoResponse.getId())
                .toUri();

        return ResponseEntity.created(location).body(pedidoResponse);
    }

    @GetMapping("/{idPedido}")
    public ResponseEntity<?> findById(@PathVariable Long idPedido) {
        return ResponseEntity.ok(pedidoService.findById(idPedido));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(pedidoService.findAll());
    }

    @PutMapping("/{idPedido}/{status}")
    public ResponseEntity<?> updateStatus(@PathVariable Long idPedido, @PathVariable Status status) {
        return ResponseEntity.ok(pedidoService.updateStatus(idPedido, status));
    }


    @DeleteMapping("/{idPedido}")
    public ResponseEntity<?> delete(@PathVariable Long idPedido) {
        pedidoService.delete(idPedido);
        return ResponseEntity.ok("Pedido " + idPedido + " deleted");
    }

}
