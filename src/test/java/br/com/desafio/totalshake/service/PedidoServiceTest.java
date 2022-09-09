package br.com.desafio.totalshake.service;


import br.com.desafio.totalshake.enums.Status;
import br.com.desafio.totalshake.model.dto.request.PedidoRequest;
import br.com.desafio.totalshake.model.dto.response.PedidoResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PedidoServiceTest {


    @Autowired
    private PedidoService service;

    private final Logger log = Logger.getLogger(this.getClass().getName());


    private Long generatedId;

    @BeforeEach
    void beforeEach() {

        var pedidoResponse = service.create(new PedidoRequest(Status.REALIZADO, null));

        this.generatedId = pedidoResponse.getId();
    }


    @Test
    void test_create() {
        var pedidoResponse = service.create(new PedidoRequest(Status.REALIZADO, null));

        assertNotNull(pedidoResponse);
        assertEquals(Status.REALIZADO, pedidoResponse.getStatus());
    }


    @Test
    void test_findAll() {

        var pedidos = service.findAll();
        log.info("Pedidos: " + pedidos);

        pedidos.forEach(pedido -> {
            assertNotNull(pedido.getId());
        });

    }

    @Test
    void test_findById() {
        var pedido = service.findById(generatedId);
        log.info("Pedido: " + pedido);
        assertEquals(generatedId, pedido.getId());
    }


    @Test
    void test_update() {

        var oldPedido = service.findById(generatedId);
        var newPedido = service.updateStatus(generatedId, Status.CANCELADO);


        assertEquals(oldPedido.getId(), newPedido.getId());
        assertNotEquals(oldPedido.getStatus(), newPedido.getStatus());
        assertEquals(Status.CANCELADO, newPedido.getStatus());
    }

    @Test
    void test_delete() {

        service.delete(generatedId);

        assertThrows(Exception.class, () -> service.findById(generatedId));
    }

}


