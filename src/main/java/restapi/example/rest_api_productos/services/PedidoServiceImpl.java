package restapi.example.rest_api_productos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restapi.example.rest_api_productos.dtos.PedidoDTO;
import restapi.example.rest_api_productos.dtos.ProductoResumenDTO;
import restapi.example.rest_api_productos.mappers.PedidoItemMapper;
import restapi.example.rest_api_productos.mappers.PedidoMapper;
import restapi.example.rest_api_productos.dtos.PedidoReporteDTO;
import restapi.example.rest_api_productos.models.Cliente;
import restapi.example.rest_api_productos.models.Pedido;
import restapi.example.rest_api_productos.models.PedidoItem;
import restapi.example.rest_api_productos.models.Producto;
import restapi.example.rest_api_productos.repository.PedidoRepository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoMapper pedidoMapper;

    @Autowired
    private PedidoItemMapper pedidoItemMapper;

    @Override
    public List<PedidoDTO> listaPedidos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream()
                .map(pedidoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PedidoDTO buscarPedidoPorId(Long id) {
         Pedido pedido = pedidoRepository.getById(id);
         return pedidoMapper.toDTO(pedido);
    }

    @Override
    public void actualizarPedido(Pedido pedido) {
        Pedido pedidoActualizado = new Pedido();
        pedidoActualizado.setCliente(pedido.getCliente());
        pedidoActualizado.setMonto(pedido.getMonto());
        pedidoActualizado.setProductos(pedido.getProductos());
        pedidoActualizado.setAcuerdoCliente(pedido.isAcuerdoCliente());
        pedidoActualizado.setDescuento(pedido.getDescuento());


        pedidoRepository.save(pedidoActualizado);

    }

    @Override
    public void eliminarPedido(Long id) {
        Pedido pedido = pedidoRepository.getById(id);
        pedidoRepository.delete(pedido);
    }

    @Override
    public double obtenerRecaudado(List<Pedido> pedidos) {
        double totalRecaudado = 0;
        for(Pedido p : pedidos) {
            totalRecaudado += p.getMonto();
        }
        return totalRecaudado;
    }

    @Override
    public void aplicarDescuento(Long id) {
        Pedido pedido = pedidoRepository.getById(id);

        if(pedido.getMonto() > 20000) {
            double montoConDescuento = pedido.getMonto() * 15 / 100;
            pedido.setMonto(montoConDescuento);
        }
        if(pedido.getMonto() > 10000) {
            double montoConDescuento = pedido.getMonto() * 10 / 100;
            pedido.setMonto(montoConDescuento);
        }

        Cliente c = pedido.getCliente();
        if(c.getPedidos().size() > 5) {
            double montoDescuento = pedido.getMonto() * 5 / 100;
            pedido.setMonto(montoDescuento);
        }

        pedidoRepository.save(pedido);
    }

    @Override
    public double verMontoPedido(Long id) {
        Pedido pedido = pedidoRepository.getById(id);
        return pedido.getMonto();
    }

    @Override
    public void eliminarProductoPedido(Long id, String producto, int cantidad) {
        Pedido pedido = pedidoRepository.getReferenceById(id);
        for(PedidoItem p : pedido.getProductos()) {
            if(p.getProducto().getNombre().equalsIgnoreCase(producto)) {
                if(p.getCantidad() == 1) {
                    pedido.getProductos().remove(p);
                }
                p.setCantidad(p.getCantidad()-cantidad);
                if(p.getCantidad() < 0) {
                    pedido.getProductos().remove(p);
                }
            } else {
                return;
            }
        }
    }

    @Override
    public HashMap<Long, Double> verPedidosPorCliente(String dni) {
        List<Pedido> pedidos = pedidoRepository.findAll();
        HashMap<Long, Double> listaPedidosCliente = new HashMap<>();
        for(Pedido p : pedidos) {
            if(p.getCliente().getDni().equalsIgnoreCase(dni)) {
                listaPedidosCliente.put(p.getId(), p.getMonto());
            }
        }
        return listaPedidosCliente;
    }

    @Override
    public PedidoReporteDTO convertirAReporteDTO(Pedido p) {
        PedidoReporteDTO pedidoReporteDTO = null;
        pedidoReporteDTO.setCliente(p.getCliente());
        pedidoReporteDTO.setProductos(p.getProductos());
        pedidoReporteDTO.setTotalConDescuentos(p.getMonto());
        return pedidoReporteDTO;
    }


    public List<Pedido> montoPedidosMayoresA6000() {
        return pedidoRepository.montoPedidosMayoresA6000();
    }
}
