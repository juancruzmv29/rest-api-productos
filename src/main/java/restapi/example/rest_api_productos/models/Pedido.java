package restapi.example.rest_api_productos.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.HashMap;

@Entity
@Table(name = "pedidos")
public class Pedido {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    @NotBlank
    private Cliente cliente;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido")
    @NotBlank
    private HashMap<Producto, Integer> productos;

    @NotBlank
    private double monto;

    @NotBlank
    private boolean acuerdoCliente;

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

    public HashMap<Producto, Integer> getProductos() {
        return productos;
    }

    public void setProductos(HashMap<Producto, Integer> productos) {
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
}
