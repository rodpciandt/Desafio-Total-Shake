package br.com.desafio.totalshake.dto;


import lombok.Data;

@Data
public class ItemPedidoResponse {

    private Long id;
    private Integer quantidade;
    private String descricao;
}
