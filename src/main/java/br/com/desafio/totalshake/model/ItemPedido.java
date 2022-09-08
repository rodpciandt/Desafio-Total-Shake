package br.com.desafio.totalshake.model;

import br.com.desafio.totalshake.model.dto.request.ItemPedidoRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ITEM_PEDIDOS")
@Getter @Setter
@NoArgsConstructor
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

    public ItemPedido(ItemPedidoRequest itemPedidoRequest, Pedido pedido) {
        this.descricao = itemPedidoRequest.descricao();
        this.quantidade = itemPedidoRequest.quantidade();
        this.pedido = pedido;
    }

    public ItemPedido(ItemPedidoRequest itemPedidoRequest) {
        this.descricao = itemPedidoRequest.descricao();
        this.quantidade = itemPedidoRequest.quantidade();
    }


    @Override
    public String toString() {
        return String.format(" {id: %d, quantidade: %d, descricao: %s, idPedido: %s} ", id, quantidade, descricao, pedido.getId());
    }

}
