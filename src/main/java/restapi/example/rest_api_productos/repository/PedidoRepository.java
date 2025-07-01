package restapi.example.rest_api_productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restapi.example.rest_api_productos.models.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
