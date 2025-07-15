package restapi.example.rest_api_productos.mappers;

import org.springframework.stereotype.Component;
import restapi.example.rest_api_productos.dtos.ClienteDTO;
import restapi.example.rest_api_productos.dtos.ClienteResumenDTO;
import restapi.example.rest_api_productos.dtos.PedidoDTO;
import restapi.example.rest_api_productos.models.Cliente;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteResumenMapper {


    public ClienteResumenDTO toDTO(Cliente cliente) {
        ClienteResumenDTO dto = new ClienteResumenDTO();
        dto.setId(cliente.getId());
        dto.setApellido(cliente.getApellidoCliente());
        dto.setNombre(cliente.getNombreCliente());
        dto.setDni(cliente.getDni());


        return dto;
    }


}
