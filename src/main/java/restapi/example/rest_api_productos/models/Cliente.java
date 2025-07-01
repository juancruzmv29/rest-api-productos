package restapi.example.rest_api_productos.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "apellido")
    @NotBlank
    private String apellidoCliente;

    @Column(name = "nombre")
    @NotBlank
    private String nombreCliente;

    @NotNull
    @Size(min = 7, max = 8)
    private String dni;

    @NotBlank
    private String mail;

    @Column(name = "domicilio")
    @NotBlank
    private String direccion;

    @NotBlank
    private String cuit;

    @Column(name = "empresa")
    @NotBlank
    private String nombreEmpresa;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

    private boolean activo;

    public Cliente(String apellidoCliente, String nombreCliente, String dni, String mail, String direccion, String cuit, String nombreEmpresa) {
        this.apellidoCliente = apellidoCliente;
        this.nombreCliente = nombreCliente;
        this.dni = dni;
        this.mail = mail;
        this.direccion = direccion;
        this.cuit = cuit;
        this.nombreEmpresa = nombreEmpresa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
