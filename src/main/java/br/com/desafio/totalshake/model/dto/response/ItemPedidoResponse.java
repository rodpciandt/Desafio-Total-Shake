package br.com.desafio.totalshake.model.dto.response;


import br.com.desafio.totalshake.model.ItemPedido;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ItemPedidoResponse {

    private Long id;
    private Long idPedido;
    private String descricao;
    private Integer quantidade;

    public ItemPedidoResponse(ItemPedido itemPedido) {
        this.id = itemPedido.getId();
        this.idPedido = itemPedido.getPedido().getId();
        this.descricao = itemPedido.getDescricao();
        this.quantidade = itemPedido.getQuantidade();
    }
}
