package br.com.desafio.totalshake.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ITEM_PEDIDO")
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
}
