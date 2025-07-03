package restapi.example.rest_api_productos.services;

import org.springframework.stereotype.Service;
import restapi.example.rest_api_productos.models.Pedido;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService{
    @Override
    public List<Pedido> listaPedidos() {
        return null;
    }

    @Override
    public Pedido buscarPedidoPorId(Long id) {
        return null;
    }

    @Override
    public void actualizarPedido(Long id) {

    }

    @Override
    public void eliminarPedido(Long id) {

    }

    @Override
    public double obtenerRecaudado(List<Pedido> pedidos) {
        return 0;
    }

    @Override
    public void aplicarDescuento(Long id) {

    }

    @Override
    public double verMontoPedido(Long id) {
        return 0;
    }

    @Override
    public List<Pedido> verPedidosPorCliente(String dni) {
        return null;
    }
}
