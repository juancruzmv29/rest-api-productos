package restapi.example.rest_api_productos.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import restapi.example.rest_api_productos.dtos.ClienteResumenDTO;
import restapi.example.rest_api_productos.dtos.PedidoDTO;
import restapi.example.rest_api_productos.dtos.PedidoItemDTO;
import restapi.example.rest_api_productos.models.Cliente;
import restapi.example.rest_api_productos.models.Pedido;
import restapi.example.rest_api_productos.models.PedidoItem;
import restapi.example.rest_api_productos.models.Producto;
import restapi.example.rest_api_productos.repository.ClienteRepository;
import restapi.example.rest_api_productos.repository.ProductoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PedidoMapper {

    @Autowired
    @Lazy
    private ClienteMapper clienteMapper;

    @Autowired
    private PedidoItemMapper pedidoItemMapper;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

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

    public Pedido toEntity(PedidoDTO dto) {

        Pedido pedido = new Pedido();
        // Buscar cliente por ID
        Cliente cliente = clienteRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        pedido.setCliente(cliente);

        // Asignar datos básicos
        pedido.setMonto(dto.getMonto());
        pedido.setDescuento(dto.getDescuento());
        pedido.setDetallePedido(dto.getDetallePedido());
        pedido.setAcuerdoCliente(dto.isAcuerdoCliente());

        // Convertir lista de items
        List<PedidoItem> items = dto.getProductos().stream()
                .map(itemDTO -> {
                    Producto producto = productoRepository.findById(itemDTO.getProductoId())
                            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
                    return new PedidoItem(pedido, producto, itemDTO.getCantidad());
                })
                .collect(Collectors.toList());

        pedido.setProductos(items); // o como sea que tengas estructurado eso

        return pedido;

    }

}
