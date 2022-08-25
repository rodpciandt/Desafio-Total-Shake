package br.com.desafio.totalshake.service;

import br.com.desafio.totalshake.dto.ItemPedidoDTO;
import br.com.desafio.totalshake.exception.ItemPedidoNotFoundException;
import br.com.desafio.totalshake.exception.PedidoNotFoundException;
import br.com.desafio.totalshake.model.ItemPedido;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.repository.ItemPedidoRepository;
import br.com.desafio.totalshake.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;



    public ItemPedidoDTO adicionarItem(Long idPedido, ItemPedidoDTO dto) {
        Pedido pedido = findPedidoById(idPedido);
        var itemPedido = itemPedidoRepository.save(ItemPedido.of(dto, pedido));

        return ItemPedidoDTO.of(itemPedido);
    }


    public List<ItemPedidoDTO> findAll() {
        var items = itemPedidoRepository.findAll();

        return items.stream().map(ItemPedidoDTO::of).toList();
    }


    public ItemPedidoDTO atualizarItem(Long idPedido, Long idItemPedido, ItemPedidoDTO dto) {
        findPedidoById(idPedido);
        var itemPedido = itemPedidoRepository.findById(idItemPedido).orElseThrow(ItemPedidoNotFoundException::new);
        var updatedItemPedido = ItemPedido.of(dto, itemPedido.getPedido());
        updatedItemPedido.setId(itemPedido.getId());

        return ItemPedidoDTO.of(itemPedidoRepository.save(updatedItemPedido));
    }

    public void deleteItem(Long id) {
        itemPedidoRepository.delete( itemPedidoRepository.findById(id).orElseThrow(ItemPedidoNotFoundException::new) );
    }
    private Pedido findPedidoById(Long id) {
        return pedidoRepository.findById(id).orElseThrow(PedidoNotFoundException::new);
    }

    public ItemPedidoDTO findItemPedidoById(Long idPedido, Long idItemPedido) {
        findPedidoById(idPedido);

        return ItemPedidoDTO.of(itemPedidoRepository.findById(idItemPedido).orElseThrow(ItemPedidoNotFoundException::new));
    }


}
