package restapi.example.rest_api_productos.dtos;

import restapi.example.rest_api_productos.models.Cliente;
import restapi.example.rest_api_productos.models.Pedido;
import restapi.example.rest_api_productos.models.PedidoItem;
import restapi.example.rest_api_productos.models.Producto;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class PedidoReporteDTO {

    private Cliente cliente;

    private List<PedidoItem> productos;

    private HashMap<Double, Long> productoMonto;

    double totalConDescuentos;

    public PedidoReporteDTO(Pedido p) {
        this.cliente = p.getCliente();
        this.productos = p.getProductos();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<PedidoItem> getProductos() {
        return productos;
    }

    public void setProductos(List<PedidoItem> productos) {
        this.productos = productos;
    }

    public HashMap<Double, Long> getProductoMonto() {
        return productoMonto;
    }

    public void setProductoMonto(HashMap<Double, Long> productoMonto) {
        this.productoMonto = productoMonto;
    }

    public double getTotalConDescuentos() {
        return totalConDescuentos;
    }

    public void setTotalConDescuentos(double totalConDescuentos) {
        this.totalConDescuentos = totalConDescuentos;
    }
}
