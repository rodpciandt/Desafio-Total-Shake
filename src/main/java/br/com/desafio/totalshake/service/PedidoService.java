package br.com.desafio.totalshake.service;

import br.com.desafio.totalshake.dto.PedidoDTO;
import br.com.desafio.totalshake.enums.Status;
import br.com.desafio.totalshake.exception.PedidoNotFoundException;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ModelMapper mapper;


    public PedidoDTO create(PedidoDTO request) {
        var pedido = repository.save(mapper.map(request, Pedido.class));
        return mapper.map(pedido, PedidoDTO.class);
    }

    public PedidoDTO findById(Long id) {
        var pedido = findPedido(id);
        return mapper.map(pedido, PedidoDTO.class);
    }

    public List<PedidoDTO> findAll() {
        var pedidos = repository.findAll();

        System.out.println(pedidos);
        return pedidos.stream().map(pedido -> mapper.map(pedido, PedidoDTO.class)).toList();
    }

    public void delete(Long id) {
        var pedido = findPedido(id);
        repository.delete(pedido);
    }

    public PedidoDTO updateStatus(Long id, Status status) {
        var pedido = findPedido(id);
        pedido.setStatus(status);
        var updatedPedido = repository.save(pedido);

        return mapper.map(updatedPedido, PedidoDTO.class);
    }

    private Pedido findPedido(Long id) {
        return repository.findById(id).orElseThrow(PedidoNotFoundException::new);
    }
}
