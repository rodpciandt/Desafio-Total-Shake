package br.com.desafio.totalshake.model.dto.request;

import br.com.desafio.totalshake.enums.Status;

import javax.validation.constraints.NotNull;
import java.util.List;


public record PedidoRequest(
        @NotNull(message = "Status should not be null")
        Status status,
        List<ItemPedidoRequest> itensPedido
) { }
