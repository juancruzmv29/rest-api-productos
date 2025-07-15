package restapi.example.rest_api_productos.dtos;


import java.util.List;

public class PedidoDTO {

    private Long id;
    private ClienteResumenDTO cliente;
    private double monto;
    private double descuento;
    private String detallePedido;
    private List<PedidoItemDTO> productos;

    public PedidoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteResumenDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteResumenDTO cliente) {
        this.cliente = cliente;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(String detallePedido) {
        this.detallePedido = detallePedido;
    }

    public List<PedidoItemDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<PedidoItemDTO> productos) {
        this.productos = productos;
    }

    public boolean isAcuerdoCliente() {
        return true;
    }
}