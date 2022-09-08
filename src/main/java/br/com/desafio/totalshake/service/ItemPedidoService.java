package br.com.desafio.totalshake.service;

import br.com.desafio.totalshake.exception.ItemPedidoNotFoundException;
import br.com.desafio.totalshake.exception.PedidoNotFoundException;
import br.com.desafio.totalshake.model.ItemPedido;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.model.dto.request.ItemPedidoRequest;
import br.com.desafio.totalshake.model.dto.response.ItemPedidoResponse;
import br.com.desafio.totalshake.repository.ItemPedidoRepository;
import br.com.desafio.totalshake.repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;


    @Autowired
    private ModelMapper mapper;

    public ItemPedidoResponse createItem(ItemPedidoRequest dto) {
        var pedido = findPedidoById(dto.idPedido());
        var itemPedido = itemPedidoRepository.save( new ItemPedido(dto, pedido));
        return new ItemPedidoResponse(itemPedido);
    }

    public List<ItemPedidoResponse> findAll() {
        var items = itemPedidoRepository.findAll();

        return items.stream().map(ItemPedidoResponse::new).toList();
    }


    public ItemPedidoResponse atualizarItem(Long idItemPedido, ItemPedidoRequest dto) {
        var itemPedido = itemPedidoRepository.findById(idItemPedido).orElseThrow(ItemPedidoNotFoundException::new);
        return  null;
    }

    public void deleteItem(Long id) {
        itemPedidoRepository.delete( itemPedidoRepository.findById(id).orElseThrow(ItemPedidoNotFoundException::new) );
    }

    private Pedido findPedidoById(Long id) {
        return pedidoRepository.findById(id).orElseThrow(PedidoNotFoundException::new);
    }

    public ItemPedidoResponse findItemPedidoById(Long idItemPedido) {
        return new ItemPedidoResponse(itemPedidoRepository.findById(idItemPedido).orElseThrow(ItemPedidoNotFoundException::new));
    }


}
