package br.com.desafio.totalshake.service;

import br.com.desafio.totalshake.exception.ItemPedidoNotFoundException;
import br.com.desafio.totalshake.model.ItemPedido;
import br.com.desafio.totalshake.model.dto.request.ItemPedidoRequest;
import br.com.desafio.totalshake.model.dto.response.ItemPedidoResponse;
import br.com.desafio.totalshake.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemPedidoService {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoResponse createItem(ItemPedidoRequest dto) {
        var pedido = pedidoService.findPedido(dto.idPedido());
        var itemPedido = itemPedidoRepository.save( new ItemPedido(dto, pedido));
        return new ItemPedidoResponse(itemPedido);
    }

    public List<ItemPedidoResponse> findAll() {
        var items = itemPedidoRepository.findAll();

        return items.stream().map(ItemPedidoResponse::new).toList();
    }


    @Transactional
    public ItemPedidoResponse atualizarItem(Long idItemPedido, ItemPedidoRequest dto) {
        var foundItemPedido = itemPedidoRepository.findById(idItemPedido).orElseThrow(ItemPedidoNotFoundException::new);
        var itemPedido = new ItemPedido(dto, pedidoService.findPedido(dto.idPedido()));
        itemPedido.setId(foundItemPedido.getId());


        return  new ItemPedidoResponse( itemPedidoRepository.save(itemPedido) );
    }

    public void deleteItem(Long id) {
        itemPedidoRepository.delete( itemPedidoRepository.findById(id).orElseThrow(ItemPedidoNotFoundException::new) );
    }


    public ItemPedidoResponse findItemPedidoById(Long idItemPedido) {
        return new ItemPedidoResponse(itemPedidoRepository.findById(idItemPedido).orElseThrow(ItemPedidoNotFoundException::new));
    }


}
