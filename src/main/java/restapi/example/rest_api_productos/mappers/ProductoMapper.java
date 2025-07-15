package restapi.example.rest_api_productos.mappers;

import org.springframework.stereotype.Component;
import restapi.example.rest_api_productos.dtos.ProductoResumenDTO;
import restapi.example.rest_api_productos.models.Producto;

@Component
public class ProductoMapper {

    public ProductoResumenDTO toDto(Producto p) {
        ProductoResumenDTO productoResumenDTO = new ProductoResumenDTO();
        productoResumenDTO.setId(p.getId());
        productoResumenDTO.setNombre(p.getNombre());
        productoResumenDTO.setPrecio(p.getPrecio());
        productoResumenDTO.setStock(p.getStock());
        return productoResumenDTO;
    }

    public Producto toEntity(ProductoResumenDTO dto) {
        Producto producto = new Producto();
        producto.setId(dto.getId());
        producto.setNombre(dto.getNombre());
        producto.setStock(dto.getStock());
        producto.setPrecio(dto.getPrecio());
        return producto;
    }


}
