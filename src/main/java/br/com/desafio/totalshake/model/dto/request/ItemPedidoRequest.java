package br.com.desafio.totalshake.model.dto.request;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;



public record ItemPedidoRequest(
   Long idPedido,
   @NotNull(message = "Descricao nao pode ser nula")
   String descricao,
   @NotNull(message = "quantidade nao pode ser nula")
   @Min( value = 0, message = "Quantidade deve ser maior que zero")
   Integer quantidade
) {}