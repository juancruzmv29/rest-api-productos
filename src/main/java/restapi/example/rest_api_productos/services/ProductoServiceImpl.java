package restapi.example.rest_api_productos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restapi.example.rest_api_productos.dtos.ProductoResumenDTO;
import restapi.example.rest_api_productos.mappers.ProductoMapper;
import restapi.example.rest_api_productos.models.Producto;
import restapi.example.rest_api_productos.repository.ProductoRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoMapper productoMapper;

    @Override
    public HashMap<Integer, String> listarProductosExistencias() {
        List<Producto> listaProductos = productoRepository.findAll();
        HashMap<Integer, String> existenciasProducto = new HashMap<>();
        for(Producto p : listaProductos) {
            existenciasProducto.put(p.getStock(), p.getNombre());
        }
        return existenciasProducto;
    }

    @Override
    public List<ProductoResumenDTO> listarProductos() {
        List<Producto> listaProductos = productoRepository.findAll();
        List<ProductoResumenDTO> listaDtos = new ArrayList<>();

        for(Producto p : listaProductos) {
            ProductoResumenDTO productoResumenDTO = productoMapper.toDto(p);
            listaDtos.add(productoResumenDTO);
        }
        return listaDtos;
    }

    @Override
    public ProductoResumenDTO buscarSiEstaProducto(String producto) {
        List<Producto> listaProductos = productoRepository.findAll();
        ProductoResumenDTO productoResumenDTO = new ProductoResumenDTO();
        for(Producto p : listaProductos) {
            if(p.getNombre().equalsIgnoreCase(producto)) {
                productoResumenDTO = productoMapper.toDto(p);
            } else {
                throw new RuntimeException("No se encuentra el producto");
            }
        }
        return productoResumenDTO;
    }

    @Override
    public ProductoResumenDTO buscarProductoPorId(Long id) {
        return productoMapper.toDto(productoRepository.getById(id));
    }


    @Override
    public void actualizarProducto(Producto p) {
        Producto producto = productoRepository.getById(p.getId());
        producto.setNombre(p.getNombre());
        producto.setDescripcion(p.getDescripcion());
        producto.setPrecio(p.getPrecio());
        producto.setStock(p.getStock());
        productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        Producto producto = productoRepository.getById(id);
        productoRepository.delete(producto);
    }

    @Override
    public void darDeBajaProducto(Long id) {
        Producto producto = productoRepository.getById(id);
        producto.setActivo(false);
        productoRepository.save(producto);
    }

    HashMap<Integer, String> buscarMinimosStocks() {
        List<Producto> productos = productoRepository.findAll();
        HashMap<Integer, String> listaProductos = new HashMap<>();
        for(Producto p : productos) {
            if (p.getStock() < 5) {
                listaProductos.put(p.getStock(), p.getNombre());
            }
        }
        return listaProductos;
    }
}
