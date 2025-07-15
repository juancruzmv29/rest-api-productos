package restapi.example.rest_api_productos.services;

import restapi.example.rest_api_productos.dtos.PedidoDTO;
import restapi.example.rest_api_productos.dtos.PedidoReporteDTO;
import restapi.example.rest_api_productos.models.Pedido;

import java.util.HashMap;
import java.util.List;

public interface PedidoService {


    List<PedidoDTO> listaPedidos();

    PedidoDTO buscarPedidoPorId(Long id);


    void actualizarPedido(Pedido p);

    void eliminarPedido(Long id);

    double obtenerRecaudado(List<Pedido> pedidos);

    void aplicarDescuento(Long id);

    double verMontoPedido(Long id);

    void eliminarProductoPedido(Long id, String producto, int cantidad);

    HashMap<Long, Double> verPedidosPorCliente(String dni);

    PedidoReporteDTO convertirAReporteDTO(Pedido p);

}
