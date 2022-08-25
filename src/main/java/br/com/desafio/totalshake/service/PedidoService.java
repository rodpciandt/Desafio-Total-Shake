package br.com.desafio.totalshake.service;

import br.com.desafio.totalshake.dto.PedidoDTO;
import br.com.desafio.totalshake.enums.Status;
import br.com.desafio.totalshake.exception.PedidoNotFoundException;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public PedidoDTO create(PedidoDTO request) {
        var pedido = repository.save(Pedido.of(request));
        return PedidoDTO.of(pedido);
    }

    public PedidoDTO findById(Long id) {
        var pedido = findPedido(id);
        return PedidoDTO.of(pedido);
    }

    public List<PedidoDTO> findAll() {
        var pedidos = repository.findAll();
        return pedidos.stream().map(PedidoDTO::of).collect(Collectors.toList());
    }

    public void delete(Long id) {
        var pedido = findPedido(id);
        repository.delete(pedido);
    }

    public PedidoDTO updateStatus(Long id, Status status) {
        var pedido = findPedido(id);
        pedido.setStatus(status);

        return PedidoDTO.of(repository.save(pedido));
    }

    private Pedido findPedido(Long id) {
        return repository.findById(id).orElseThrow(PedidoNotFoundException::new);
    }
}
