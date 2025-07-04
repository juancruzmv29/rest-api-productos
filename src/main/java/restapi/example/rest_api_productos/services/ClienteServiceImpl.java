package restapi.example.rest_api_productos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restapi.example.rest_api_productos.dtos.ClienteDTO;
import restapi.example.rest_api_productos.models.Cliente;
import restapi.example.rest_api_productos.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public List<Cliente> mostrarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente obtenerCliente(String dni) {
        return clienteRepository.obtenerClientePorDNI(dni);
    }

    @Override
    public Cliente guardarCliente(Cliente c) {
        return clienteRepository.save(c);
    }

    @Override
    public void darDeBajaCliente(String dni) {
        Cliente c = clienteRepository.obtenerClientePorDNI(dni);
        c.setActivo(false);
        clienteRepository.save(c);
    }

    @Override
    public void actualizarCliente(Cliente c) {
        Cliente cliente = clienteRepository.obtenerClientePorDNI(c.getDni());
        cliente.setApellidoCliente(c.getApellidoCliente());
        cliente.setNombreCliente(c.getNombreCliente());
        cliente.setDni(cliente.getDni());
        cliente.setCuit(c.getCuit());
        cliente.setDireccion(c.getDireccion());
        cliente.setMail(c.getMail());
        cliente.setNombreEmpresa(c.getNombreEmpresa());
        clienteRepository.save(c);
    }

    @Override
    public ClienteDTO convertirAClienteDTO(Cliente c) {
        ClienteDTO clienteDTO = null;
        clienteDTO.setApellidoCliente(c.getApellidoCliente());
        clienteDTO.setNombreCliente(c.getNombreCliente());
        clienteDTO.setCuit(c.getCuit());
        clienteDTO.setDni(c.getDni());
        clienteDTO.setDireccion(c.getDireccion());
        clienteDTO.setMail(c.getMail());
        clienteDTO.setNombreEmpresa(c.getNombreEmpresa());
        return clienteDTO;
    }
}
