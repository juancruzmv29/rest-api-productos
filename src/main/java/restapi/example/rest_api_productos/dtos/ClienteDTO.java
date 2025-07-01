package restapi.example.rest_api_productos.dtos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import restapi.example.rest_api_productos.models.Pedido;

import java.util.List;

public class ClienteDTO {


    private Long id;


    private String apellidoCliente;


    private String nombreCliente;

    private String dni;

    private String mail;

    private String direccion;


    private String cuit;


    private String nombreEmpresa;


    private List<Pedido> pedidos;

    private boolean activo;

    public ClienteDTO(Long id, String apellidoCliente, String nombreCliente, String dni, String mail, String direccion, String cuit, String nombreEmpresa, List<Pedido> pedidos) {
        this.id = id;
        this.apellidoCliente = apellidoCliente;
        this.nombreCliente = nombreCliente;
        this.dni = dni;
        this.mail = mail;
        this.direccion = direccion;
        this.cuit = cuit;
        this.nombreEmpresa = nombreEmpresa;
        this.pedidos = pedidos;
        this.activo = false;
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

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}