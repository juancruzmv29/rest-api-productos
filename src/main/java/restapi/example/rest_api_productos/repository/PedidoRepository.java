package restapi.example.rest_api_productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import restapi.example.rest_api_productos.models.Pedido;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {


    @Query("SELECT p FROM Pedido p WHERE p.monto > 6000")
    List<Pedido> montoPedidosMayoresA6000();


}
