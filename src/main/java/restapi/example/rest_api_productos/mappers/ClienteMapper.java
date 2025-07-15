package restapi.example.rest_api_productos.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import restapi.example.rest_api_productos.dtos.ClienteDTO;
import restapi.example.rest_api_productos.dtos.PedidoDTO;
import restapi.example.rest_api_productos.models.Cliente;
import restapi.example.rest_api_productos.models.Pedido;
import restapi.example.rest_api_productos.models.PedidoItem;
import restapi.example.rest_api_productos.models.Producto;
import restapi.example.rest_api_productos.repository.ClienteRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteMapper {

    @Autowired
    @Lazy
    PedidoMapper pedidoMapper;

    @Autowired
    ClienteRepository clienteRepository;

    public ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setApellidoCliente(cliente.getApellidoCliente());
        dto.setNombreCliente(cliente.getNombreCliente());
        dto.setDni(cliente.getDni());
        dto.setMail(cliente.getMail());
        dto.setDireccion(cliente.getDireccion());
        dto.setCuit(cliente.getCuit());
        dto.setNombreEmpresa(cliente.getNombreEmpresa());
        dto.setActivo(false);

        List<PedidoDTO> pedidosDTO = cliente.getPedidos()
                .stream()
                .map(pedidoMapper::toDTO)
                .collect(Collectors.toList());
        dto.setPedidos(pedidosDTO);
        return dto;
    }

    public Cliente toEntity(ClienteDTO dto) {

        Cliente cliente = new Cliente();
        // Buscar cliente por ID
        cliente = clienteRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        // Asignar datos básicos
        cliente.setDni(dto.getDni());
        cliente.setMail(dto.getMail());
        cliente.setCuit(dto.getCuit());
        cliente.setNombreCliente(dto.getNombreCliente());
        cliente.setApellidoCliente(dto.getApellidoCliente());
        cliente.setNombreEmpresa(dto.getNombreEmpresa());


        return cliente;

    }
}
