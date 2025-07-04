package restapi.example.rest_api_productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import restapi.example.rest_api_productos.models.Producto;

import java.util.HashMap;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {


    @Query("SELECT p FROM PRODUCTOS p WHERE p.stock < 5")
    HashMap<Integer, String> buscarMinimosStocks();

}
