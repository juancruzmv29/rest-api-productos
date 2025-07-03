package restapi.example.rest_api_productos.services;

import restapi.example.rest_api_productos.dtos.ClienteDTO;
import restapi.example.rest_api_productos.models.Cliente;

import java.util.List;

public interface ClienteService {


    List<Cliente> mostrarClientes();

    Cliente obtenerCliente(String dni);

    void guardarCliente(Cliente c);

    void darDeBajaCliente(Cliente c);

    void actualizarCliente(Cliente c);




}
