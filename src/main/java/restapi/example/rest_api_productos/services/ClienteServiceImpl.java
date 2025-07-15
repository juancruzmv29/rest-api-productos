package restapi.example.rest_api_productos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restapi.example.rest_api_productos.dtos.ClienteDTO;
import restapi.example.rest_api_productos.dtos.ClienteResumenDTO;
import restapi.example.rest_api_productos.mappers.ClienteMapper;
import restapi.example.rest_api_productos.mappers.ClienteResumenMapper;
import restapi.example.rest_api_productos.models.Cliente;
import restapi.example.rest_api_productos.repository.ClienteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private ClienteResumenMapper clienteResumenMapper;


    @Override
    public List<ClienteResumenDTO> mostrarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteResumenDTO> clienteResumenDTOS = new ArrayList<>();
        for(Cliente c : clientes) {
            clienteResumenDTOS.add(clienteResumenMapper.toDTO(c));
        }
        return clienteResumenDTOS;
    }

    @Override
    public ClienteDTO obtenerCliente(String dni) {
        Cliente c = clienteRepository.obtenerClientePorDNI(dni);
        return clienteMapper.toDTO(c);
    }

    @Override
    public ClienteDTO guardarCliente(Cliente c) {
        Cliente cliente = clienteRepository.save(c);
        return clienteMapper.toDTO(cliente);
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
        clienteRepository.save(cliente);
    }

    @Override
    public void eliminarCliente(Cliente c) {
        clienteRepository.delete(c);
    }

    @Override
    public ClienteDTO convertirAClienteDTO(Cliente c) {
        ClienteDTO clienteDTO = new ClienteDTO();
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
