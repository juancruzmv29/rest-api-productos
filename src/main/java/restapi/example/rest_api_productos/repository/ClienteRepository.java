package restapi.example.rest_api_productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import restapi.example.rest_api_productos.models.Cliente;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    @Query("SELECT c FROM CLIENTE c WHERE c.pedidos > 5")
    List<Cliente> buscarClientesConMasPedidos();

    @Query("SELECT c FROM CLIENTE c WHERE c.dni == %dni%")
    Cliente obtenerClientePorDNI(String dni);
}
