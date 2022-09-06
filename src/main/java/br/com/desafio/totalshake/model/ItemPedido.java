package br.com.desafio.totalshake.model;

import br.com.desafio.totalshake.dto.ItemPedidoDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ITEM_PEDIDOS")
@Getter @Setter
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

    @Override
    public String toString() {
        return String.format(" {id: %d, quantidade: %d, descricao: %s, idPedido: %s} ", id, quantidade, descricao, pedido.getId());
    }

}
