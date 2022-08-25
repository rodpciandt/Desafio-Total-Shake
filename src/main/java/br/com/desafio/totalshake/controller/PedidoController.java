package br.com.desafio.totalshake.controller;

import br.com.desafio.totalshake.dto.ItemPedidoDTO;
import br.com.desafio.totalshake.dto.PedidoDTO;
import br.com.desafio.totalshake.enums.Status;
import br.com.desafio.totalshake.service.ItemPedidoService;
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

    @Autowired
    private ItemPedidoService itemPedidoService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody PedidoDTO pedido) {
        var pedidoResponse = this.pedidoService.create(pedido);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pedidoResponse.getId())
                .toUri();

        return ResponseEntity.created(location).body(pedidoResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(pedidoService.findAll());
    }

    @PutMapping("/{id}/{status}")
    public ResponseEntity<?> updateStatus(@PathVariable Long id, @PathVariable Status status) {
        return ResponseEntity.ok(pedidoService.updateStatus(id, status));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        pedidoService.delete(id);
        return ResponseEntity.ok("Pedido " + id + " deleted");
    }

    @PostMapping("/{id}/itens")
    public ResponseEntity<?> adicionarItem(@PathVariable Long id, @Valid @RequestBody ItemPedidoDTO itemPedidoRequest) {
        return ResponseEntity.ok(itemPedidoService.adicionarItem(id, itemPedidoRequest));
    }


    @GetMapping("{idPedido}/itens/{idPedido}")
    public ResponseEntity<?> findPedidoById( @PathVariable Long idPedido,  @PathVariable Long idItemPedido) {
        return ResponseEntity.ok(itemPedidoService.findItemPedidoById(idPedido, idItemPedido));
    }

    @PutMapping("/{idPedido}/itens/{idPedido}")
    public ResponseEntity<?> updateItemPedido( @PathVariable Long idPedido,  @PathVariable Long idItemPedido, @RequestBody ItemPedidoDTO itemPedidoRequest) {
        return ResponseEntity.ok( itemPedidoService.atualizarItem(idPedido, idItemPedido, itemPedidoRequest));
    }


}
