package br.com.desafio.totalshake.dto;

import br.com.desafio.totalshake.model.Pedido;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component("pedidoIO")
public class PedidoIO {

    private ModelMapper mapper;

    final Converter<PedidoRequest, Pedido> converter = new Converter<>() {
        @Override
        public Pedido convert(MappingContext<PedidoRequest, Pedido> context) {
            PedidoRequest request = context.getSource();
            Pedido pedido = new Pedido();

            pedido.setDataHora(request.getDataHora());
            pedido.setStatus(request.getStatus());

            return pedido;
        }
    };

    public PedidoIO() {
        mapper = new ModelMapper();
        mapper.addConverter(converter);
    }

    public Pedido mapTo(PedidoRequest request) {
        return this.mapper.map(request, Pedido.class);
    }

}
