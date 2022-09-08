package br.com.desafio.totalshake.service;

import br.com.desafio.totalshake.enums.Status;
import br.com.desafio.totalshake.exception.PedidoNotFoundException;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.model.dto.request.PedidoRequest;
import br.com.desafio.totalshake.model.dto.response.PedidoResponse;
import br.com.desafio.totalshake.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Transactional
    public PedidoResponse create(PedidoRequest request) {
        Pedido savedPedido = repository.save(new Pedido(request));
        return new PedidoResponse(savedPedido);
    }

    @Transactional(readOnly = true)
    public PedidoResponse findById(Long id) {
        var pedido = findPedido(id);
        return new PedidoResponse(pedido);
    }

    public List<PedidoResponse> findAll() {
        var pedidos = repository.findAll();
        return pedidos.stream().map(PedidoResponse::new).toList();
    }

    public void delete(Long id) {

        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new PedidoNotFoundException();
        }
    }

    public PedidoResponse updateStatus(Long id, Status status) {
        var pedido = findPedido(id);
        pedido.setStatus(status);
        var updatedPedido = repository.save(pedido);

        return new PedidoResponse(updatedPedido);
    }

    public Pedido findPedido(Long id) {
        return repository.findById(id).orElseThrow(PedidoNotFoundException::new);
    }
}
