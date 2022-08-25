package br.com.desafio.totalshake.dto;

import br.com.desafio.totalshake.model.ItemPedido;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@JsonPropertyOrder({"id", "descricao", "quantidade"})
public class ItemPedidoDTO {


    @NotNull
    private Long id;

    @NotEmpty(message = "Descricao nao pode estar vazia")
    private String descricao;

    @NotNull(message = "Quantidade nao pode ser nula.")
    private Integer quantidade;

    public static ItemPedidoDTO of(ItemPedido itemPedido) {
        var dto = new ItemPedidoDTO();

        dto.setId(itemPedido.getId());
        dto.setDescricao(itemPedido.getDescricao());
        dto.setQuantidade(itemPedido.getQuantidade());

        return dto;
    }
}
