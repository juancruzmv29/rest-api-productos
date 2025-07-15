package restapi.example.rest_api_productos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import restapi.example.rest_api_productos.dtos.ProductoResumenDTO;
import restapi.example.rest_api_productos.mappers.ProductoMapper;
import restapi.example.rest_api_productos.models.Producto;
import restapi.example.rest_api_productos.services.ProductoService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/productos")
public class ProductoController {


    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProductoMapper productoMapper;


    @GetMapping("/")
    public List<ProductoResumenDTO> listaProductos() {
        return productoService.listarProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarSiEstaProducto(@Param("String") String producto) {
        ProductoResumenDTO productoResumenDTO = new ProductoResumenDTO();
        Map<String, Object> response = new HashMap<>();


        try {
            productoResumenDTO = productoService.buscarSiEstaProducto(producto);
        } catch (Exception e) {
            response.put("mensaje", "Error al obtener los pedidos de un cliente");
            response.put("error", e.getMessage());
        }
        response.put("mensaje", "producto obtenido con exito");
        response.put("producto", productoResumenDTO);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarProducto(@RequestBody ProductoResumenDTO productoResumenDTO) {
        ProductoResumenDTO productoResumen = new ProductoResumenDTO();
        Producto producto = new Producto();
        Map<String, Object> response = new HashMap<>();



        try {
            productoResumen = productoService.buscarSiEstaProducto(productoResumenDTO.getNombre());
            producto = productoMapper.toEntity(productoResumen);
            productoService.actualizarProducto(producto);
        } catch (Exception e) {
            response.put("mensaje", "Error al obtener el producto");
            response.put("error", e.getMessage());
        }
        response.put("mensaje", "producto modificado con exito");
        response.put("producto", producto);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Long id) {
        ProductoResumenDTO productoResumenDTO = new ProductoResumenDTO();
        Map<String, Object> response = new HashMap<>();



        try {
            productoResumenDTO = productoService.buscarProductoPorId(id);
            productoService.eliminarProducto(id);
        } catch (Exception e) {
            response.put("mensaje", "Error al eliminar el producto");
            response.put("error", e.getMessage());
        }

        response.put("mensaje", "producto eliminado con exito");
        response.put("producto", productoResumenDTO);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}/producto")
    public ResponseEntity<?> darDeBajaProducto(@PathVariable Long id) {
        ProductoResumenDTO productoResumenDTO = new ProductoResumenDTO();
        Map<String, Object> response = new HashMap<>();


        try {
            productoResumenDTO = productoService.buscarProductoPorId(id);
            productoService.darDeBajaProducto(id);
        } catch (Exception e) {
            response.put("mensaje", "Error al dar de baja el producto");
            response.put("error", e.getMessage());
        }
        response.put("mensaje", "producto dado de baja con exito");
        response.put("producto", productoResumenDTO);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

}
