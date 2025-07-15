package restapi.example.rest_api_productos.services;

import restapi.example.rest_api_productos.dtos.ProductoResumenDTO;
import restapi.example.rest_api_productos.models.Producto;

import java.util.HashMap;
import java.util.List;

public interface ProductoService {


    HashMap<Integer, String> listarProductosExistencias();

    List<ProductoResumenDTO> listarProductos();

    ProductoResumenDTO buscarSiEstaProducto(String producto);

    ProductoResumenDTO buscarProductoPorId(Long id);


    void actualizarProducto(Producto p);

    void eliminarProducto(Long id);

    void darDeBajaProducto(Long id);



}
