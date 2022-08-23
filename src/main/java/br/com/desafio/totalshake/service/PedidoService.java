package br.com.desafio.totalshake.service;

import br.com.desafio.totalshake.dto.PedidoRequest;
import br.com.desafio.totalshake.dto.PedidoResponse;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {


    @Autowired
    private PedidoRepository repository;

    public PedidoResponse create(PedidoRequest request) {
        var saved = repository.save(Pedido.of(request));
        return PedidoResponse.of(saved);
    }

}
