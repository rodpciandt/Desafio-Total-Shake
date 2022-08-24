package br.com.desafio.totalshake.service;

import br.com.desafio.totalshake.dto.PedidoIO;
import br.com.desafio.totalshake.dto.PedidoRequest;
import br.com.desafio.totalshake.dto.PedidoResponse;
import br.com.desafio.totalshake.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {


    @Autowired
    private PedidoRepository repository;

    @Autowired
    private PedidoIO pedidoIO;

    public PedidoResponse create(PedidoRequest request) {
        var saved = repository.save(pedidoIO.mapTo(request));
        return PedidoResponse.of(saved);
    }

    public PedidoResponse findById(Long id) {
        var pedido = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        return PedidoResponse.of(pedido);
    }

    public List<PedidoResponse> findAll() {
        var pedidos = repository.findAll();
        return pedidos.stream().map(PedidoResponse::of).collect(Collectors.toList());
    }

    public Object delete(Long id) {
        return null;
    }
}
