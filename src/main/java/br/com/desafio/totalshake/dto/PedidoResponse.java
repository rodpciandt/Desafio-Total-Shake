package br.com.desafio.totalshake.dto;

import br.com.desafio.totalshake.enums.Status;
import br.com.desafio.totalshake.model.Pedido;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PedidoResponse {

    @JsonProperty("pedido_id")
    private Long id;
    @JsonProperty("data_hora")
    private LocalDateTime dataHora;
    private Status status;

    @JsonProperty("itens_pedido")
    private List<ItemPedidoResponse> itens;

    public static PedidoResponse of(Pedido saved) {
        return new PedidoResponse();
    }
}
