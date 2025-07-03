package restapi.example.rest_api_productos.services;

import restapi.example.rest_api_productos.models.Pedido;

import java.util.List;

public interface PedidoService {


    List<Pedido> listaPedidos();

    Pedido buscarPedidoPorId(Long id);

    void actualizarPedido(Long id);

    void eliminarPedido(Long id);

    double obtenerRecaudado(List<Pedido> pedidos);

    void aplicarDescuento(Long id);

    double verMontoPedido(Long id);

    List<Pedido> verPedidosPorCliente(String dni);

}
