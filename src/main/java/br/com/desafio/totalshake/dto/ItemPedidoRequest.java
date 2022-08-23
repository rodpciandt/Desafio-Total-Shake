package br.com.desafio.totalshake.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemPedidoRequest {
    private String descricao;
    private Integer quantidade;
}
