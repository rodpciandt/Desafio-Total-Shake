package br.com.desafio.totalshake.dto;

import br.com.desafio.totalshake.enums.Status;
import br.com.desafio.totalshake.model.Pedido;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@JsonPropertyOrder({"pedido_id", "dataHora", "status", "itens"})
public class PedidoDTO {

    @JsonProperty("pedido_id")
    private Long id;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime dataHora;

    @NotNull(message = "Status nao pode ser nulo")
    private Status status;

    private List<ItemPedidoDTO> itens;
}
