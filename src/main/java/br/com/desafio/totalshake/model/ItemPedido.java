package br.com.desafio.totalshake.model;

import br.com.desafio.totalshake.dto.ItemPedidoDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ITEM_PEDIDOS")
@Data
public class ItemPedido {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    public static ItemPedido of(ItemPedidoDTO dto, Pedido pedido) {
        var itemPedido = new ItemPedido();

        itemPedido.setPedido(pedido);
        itemPedido.setDescricao(dto.getDescricao());
        itemPedido.setQuantidade(dto.getQuantidade());

        return itemPedido;
    }

}
