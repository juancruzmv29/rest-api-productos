package restapi.example.rest_api_productos.services;

import org.springframework.stereotype.Service;
import restapi.example.rest_api_productos.models.Producto;

import java.util.HashMap;

@Service
public class ProductoServiceImpl implements ProductoService{
    @Override
    public HashMap<Integer, Producto> listarProductosExistencias() {
        return null;
    }

    @Override
    public boolean buscarSiEstaProducto(String producto) {
        return false;
    }

    @Override
    public void actualizarProducto(Long id) {

    }

    @Override
    public void eliminarProducto(Long id) {

    }

    @Override
    public void darDeBajaProducto(Long id) {

    }
}
