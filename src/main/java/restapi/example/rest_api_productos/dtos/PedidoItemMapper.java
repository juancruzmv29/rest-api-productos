package restapi.example.rest_api_productos.dtos;

import org.springframework.stereotype.Component;
import restapi.example.rest_api_productos.models.PedidoItem;

@Component
public class PedidoItemMapper {

    public PedidoItemDTO toDTO(PedidoItem item) {
        PedidoItemDTO dto = new PedidoItemDTO();
        dto.setNombreProducto(item.getProducto().getNombre());
        dto.setPrecioUnitario(item.getProducto().getPrecio());
        dto.setCantidad(item.getCantidad());
        dto.setSubtotal(item.getCantidad() * item.getProducto().getPrecio());
        return dto;
    }

}
