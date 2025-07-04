package restapi.example.rest_api_productos.services;

import restapi.example.rest_api_productos.models.Producto;

import java.util.HashMap;

public interface ProductoService {


    HashMap<Integer, String> listarProductosExistencias();

    boolean buscarSiEstaProducto(String producto);


    void actualizarProducto(Producto p);

    void eliminarProducto(Long id);

    void darDeBajaProducto(Long id);



}
