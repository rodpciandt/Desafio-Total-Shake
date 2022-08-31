package br.com.desafio.totalshake.controller;

import br.com.desafio.totalshake.dto.PedidoDTO;
import br.com.desafio.totalshake.enums.Status;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.service.PedidoService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/pedidos/")
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
    public EntityModel<PedidoDTO> findById(@PathVariable Long idPedido) {

        var pedido = pedidoService.findById(idPedido);

        var model = EntityModel.of(pedido);
        var linkToPedidos = linkTo(methodOn(this.getClass()).findAll());

        model.add(linkToPedidos.withRel("all_pedidos"));
        return model;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<PedidoDTO> pedidos = pedidoService.findAll();

        // dynamic filtering
//        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("status");
//        FilterProvider filters = new SimpleFilterProvider().addFilter("PedidoFilter", filter);
//        MappingJacksonValue mapping = new MappingJacksonValue(pedidos);
//        mapping.setFilters(filters);


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
