package restapi.example.rest_api_productos.services;

import org.springframework.stereotype.Service;
import restapi.example.rest_api_productos.dtos.ClienteDTO;
import restapi.example.rest_api_productos.models.Cliente;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Override
    public List<Cliente> mostrarClientes() {
        return null;
    }

    @Override
    public Cliente obtenerCliente(String dni) {
        return null;
    }

    @Override
    public void guardarCliente(Cliente c) {

    }

    @Override
    public void darDeBajaCliente(Cliente c) {

    }

    @Override
    public void actualizarCliente(Cliente c) {

    }

    @Override
    public ClienteDTO convertirAClienteDTO(Cliente c) {
        return null;
    }
}
