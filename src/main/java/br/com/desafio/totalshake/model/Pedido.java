package br.com.desafio.totalshake.model;


import br.com.desafio.totalshake.dto.PedidoRequest;
import br.com.desafio.totalshake.enums.Status;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "PEDIDO")
@Data
public class Pedido {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itensPedido;

    public static Pedido of(PedidoRequest request) {
        return new Pedido();
    }
}
