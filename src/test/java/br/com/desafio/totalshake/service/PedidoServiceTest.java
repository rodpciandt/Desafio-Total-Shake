package br.com.desafio.totalshake.service;


import br.com.desafio.totalshake.dto.PedidoDTO;
import br.com.desafio.totalshake.enums.Status;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PedidoServiceTest {


    @Autowired
    private PedidoService service;

    private final Logger log = Logger.getLogger(this.getClass().getName());
    @Test
    @DisplayName("[Create Pedido]")
    void test_createPedido() {

        var pedidoDTO = new PedidoDTO();
        pedidoDTO.setStatus(Status.REALIZADO);
        PedidoDTO createdPedidoDTO = service.create(pedidoDTO);

        log.info("PedidoDTO request: " + pedidoDTO);
        log.info("PedidoDTO response: " + createdPedidoDTO);

        assertEquals(pedidoDTO.getStatus(), createdPedidoDTO.getStatus());
        assertNotNull(createdPedidoDTO.getId());
    }

    @Test
    @DisplayName("[FindAll Pedidos]")
    void test_findAll() {
        List<PedidoDTO> pedidos = service.findAll();

        log.info("Pedidos: " + pedidos);
    }
}
