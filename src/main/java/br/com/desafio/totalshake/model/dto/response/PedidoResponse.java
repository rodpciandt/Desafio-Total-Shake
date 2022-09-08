package br.com.desafio.totalshake.model.dto.response;

import br.com.desafio.totalshake.enums.Status;
import br.com.desafio.totalshake.model.Pedido;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class PedidoResponse {

    private Long id;
    private Status status;
    private LocalDateTime dataHora;
    private List<ItemPedidoResponse> itens;

    public PedidoResponse(Pedido pedido) {
        this.id = pedido.getId();
        this.status = pedido.getStatus();
        this.dataHora = pedido.getDataHora();

        if ( pedido.getItensPedido() != null) {
            this.itens = pedido.getItensPedido().stream().map(itemPedido -> new ItemPedidoResponse(itemPedido)).toList();
        }
    }
}
