package restapi.example.rest_api_productos.dtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import restapi.example.rest_api_productos.models.Cliente;
import restapi.example.rest_api_productos.models.Pedido;
import restapi.example.rest_api_productos.models.PedidoItem;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PedidoMapper {

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private PedidoItemMapper pedidoItemMapper;

    public PedidoDTO toDTO(Pedido pedido) {
        PedidoDTO dto = new PedidoDTO();
        dto.setId(pedido.getId());
        Cliente cliente = pedido.getCliente();

        ClienteResumenDTO resumen = new ClienteResumenDTO(
                cliente.getId(),
                cliente.getNombreCliente(),
                cliente.getApellidoCliente(),
                cliente.getDni()
        );

        dto.setCliente(resumen);

        dto.setDescuento(pedido.getDescuento());
        dto.setDetallePedido(pedido.getDetallePedido());
        dto.setMonto(pedido.getMonto());

        // Mapear los productos del pedido a PedidoItemDTO
        List<PedidoItemDTO> itemsDTO = pedido.getProductos()
                .stream()
                .map(pedidoItemMapper::toDTO)
                .collect(Collectors.toList());
        dto.setProductos(itemsDTO);

        return dto;
    }

}
