package br.com.desafio.totalshake.model;


import br.com.desafio.totalshake.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "PEDIDOS")
@Getter
@Setter
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

    @OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ItemPedido> itensPedido;

    @PrePersist
    void prePersist() {
        this.dataHora = LocalDateTime.now();
    }


    @Override
    public String toString() {
        return String.format(" Pedido { id:  %d, dataHora: %s, status: %s, itensPedido: %s}", id, dataHora, status, itensPedido);
    }


}
