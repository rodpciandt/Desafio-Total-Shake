package br.com.desafio.totalshake.controller;

import br.com.desafio.totalshake.model.dto.request.ItemPedidoRequest;
import br.com.desafio.totalshake.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "itens-pedido")
public class ItemPedidoController {


    @Autowired
    private ItemPedidoService itemPedidoService;

    @PostMapping("/")
    public ResponseEntity<?> adicionarItem(@Valid @RequestBody ItemPedidoRequest itemPedidoRequest) {
        return ResponseEntity.ok(itemPedidoService.createItem(itemPedidoRequest));
    }

    @GetMapping("/{idItemPedido}")
    public ResponseEntity<?> findPedidoById(@PathVariable Long idItemPedido) {
        return ResponseEntity.ok(itemPedidoService.findItemPedidoById(idItemPedido));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(itemPedidoService.findAll());
    }

    @PutMapping("/{idItemPedido}")
    public ResponseEntity<?> updateItemPedido(@PathVariable Long idItemPedido, @RequestBody ItemPedidoRequest itemPedidoRequest) {
        return ResponseEntity.ok(itemPedidoService.atualizarItem(idItemPedido, itemPedidoRequest));
    }

    @DeleteMapping("/{idItemPedido}")
    public ResponseEntity<?> deleteItemPedido(@PathVariable Long idItemPedido) {
        itemPedidoService.deleteItem(idItemPedido);
        return ResponseEntity.ok("Item " + idItemPedido + " deletado.");
    }

}
