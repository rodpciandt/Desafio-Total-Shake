package br.com.desafio.totalshake.controller;

import br.com.desafio.totalshake.enums.Status;
import br.com.desafio.totalshake.model.dto.request.PedidoRequest;
import br.com.desafio.totalshake.model.dto.response.PedidoResponse;
import br.com.desafio.totalshake.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pedidos/")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;


    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody PedidoRequest pedido) {
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
        var pedido = pedidoService.findById(idPedido);
        var model = EntityModel.of(pedido);

        return ResponseEntity.ok(model);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<PedidoResponse> pedidos = pedidoService.findAll();
        return ResponseEntity.ok(pedidos);
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
