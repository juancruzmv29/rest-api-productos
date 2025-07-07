package restapi.example.rest_api_productos.dtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import restapi.example.rest_api_productos.models.Cliente;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteMapper {

    @Autowired
    PedidoMapper pedidoMapper;

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


}
