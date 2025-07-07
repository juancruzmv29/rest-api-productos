package restapi.example.rest_api_productos.dtos;

import restapi.example.rest_api_productos.models.PedidoItem;

public class PedidoItemDTO {

    private String nombreProducto;

    private double precioUnitario;

    private int cantidad;

    private double subtotal;

    public PedidoItemDTO() {
    }

    public PedidoItemDTO(PedidoItem pedidoItem) {
        this.nombreProducto = pedidoItem.getProducto().getNombre();
        this.precioUnitario = pedidoItem.getProducto().getPrecio();
        this.cantidad = pedidoItem.getCantidad();
        this.subtotal = pedidoItem.getCantidad() * pedidoItem.getProducto().getPrecio();
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
