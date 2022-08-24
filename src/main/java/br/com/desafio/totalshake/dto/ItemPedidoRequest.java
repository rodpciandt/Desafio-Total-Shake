package br.com.desafio.totalshake.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ItemPedidoRequest {


    @NotEmpty
    private String descricao;

    @NotEmpty
    private Integer quantidade;
}
