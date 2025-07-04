package restapi.example.rest_api_productos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import restapi.example.rest_api_productos.dtos.PedidoReporteDTO;
import restapi.example.rest_api_productos.models.Cliente;
import restapi.example.rest_api_productos.models.Pedido;
import restapi.example.rest_api_productos.repository.PedidoRepository;

import java.util.HashMap;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> listaPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido buscarPedidoPorId(Long id) {
        return pedidoRepository.getById(id);
    }

    @Override
    public void actualizarPedido(Pedido p) {
        Pedido pedido = pedidoRepository.getById(p.getId());
        pedido.setCliente(p.getCliente());
        pedido.setDetallePedido(p.getDetallePedido());
        pedido.setProductos(p.getProductos());
        pedido.setMonto(p.getMonto());
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
    public HashMap<Long, Double> verPedidosPorCliente(String dni) {
        List<Pedido> pedidos = pedidoRepository.findAll();
        HashMap<Long, Double> listaPedidosCliente = null;
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
