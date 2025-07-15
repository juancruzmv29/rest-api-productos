package restapi.example.rest_api_productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import restapi.example.rest_api_productos.dtos.ClienteDTO;
import restapi.example.rest_api_productos.dtos.ClienteResumenDTO;
import restapi.example.rest_api_productos.models.Cliente;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    @Query("SELECT c FROM Cliente c WHERE SIZE(c.pedidos) > 5")
    List<ClienteResumenDTO> buscarClientesConMasPedidos();

    @Query("SELECT c FROM Cliente c WHERE c.dni = :dni")
    Cliente obtenerClientePorDNI(@Param("dni")String dni);
}
