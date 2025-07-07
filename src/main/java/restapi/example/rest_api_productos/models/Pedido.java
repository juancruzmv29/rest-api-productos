package restapi.example.rest_api_productos.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cliente_id")
    @NotBlank
    private Cliente cliente;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido", orphanRemoval = true)
    @NotNull
    private List<PedidoItem> productos; // Id, cantidad

    @NotNull
    private double monto;

    @NotNull
    private double descuento;

    @NotBlank
    private boolean acuerdoCliente;

    @NotBlank
    private String detallePedido;

    public Pedido() {
    }

    public Pedido(Cliente cliente, double monto) {
        this.cliente = cliente;
        this.monto = monto;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public boolean isAcuerdoCliente() {
        return acuerdoCliente;
    }

    public void setAcuerdoCliente(boolean acuerdoCliente) {
        this.acuerdoCliente = acuerdoCliente;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String toString() {
        return "";
    }

    public String getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(String detallePedido) {
        this.detallePedido = detallePedido;
    }
}
