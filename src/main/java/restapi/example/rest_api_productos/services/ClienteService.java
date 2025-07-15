package restapi.example.rest_api_productos.services;

import restapi.example.rest_api_productos.dtos.ClienteDTO;
import restapi.example.rest_api_productos.dtos.ClienteResumenDTO;
import restapi.example.rest_api_productos.models.Cliente;

import java.util.List;

public interface ClienteService {


    List<ClienteResumenDTO> mostrarClientes();

    ClienteDTO obtenerCliente(String dni);

    ClienteDTO guardarCliente(Cliente c);

    void darDeBajaCliente(String dni);

    void actualizarCliente(Cliente c);

    void eliminarCliente(Cliente c);


    ClienteDTO convertirAClienteDTO(Cliente c);
}
