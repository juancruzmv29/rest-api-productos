package restapi.example.rest_api_productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restapi.example.rest_api_productos.models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
