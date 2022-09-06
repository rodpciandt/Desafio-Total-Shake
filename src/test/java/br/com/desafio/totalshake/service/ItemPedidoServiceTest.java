package br.com.desafio.totalshake.service;

import br.com.desafio.totalshake.dto.ItemPedidoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ItemPedidoServiceTest {

    @Autowired
    private ItemPedidoService service;

    @Test
    void test_create() {

        var x = new ItemPedidoDTO();

        x.setIdPedido(1L);
        x.setDescricao("Description");
        x.setQuantidade(3);

        ItemPedidoDTO saved = service.adicionarItem(x);

        System.out.println(x);
        System.out.println(saved);
    }

}
