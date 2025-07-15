package restapi.example.rest_api_productos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import restapi.example.rest_api_productos.dtos.PedidoDTO;
import restapi.example.rest_api_productos.dtos.PedidoItemDTO;
import restapi.example.rest_api_productos.dtos.ProductoResumenDTO;
import restapi.example.rest_api_productos.mappers.PedidoMapper;
import restapi.example.rest_api_productos.models.Pedido;
import restapi.example.rest_api_productos.models.PedidoItem;
import restapi.example.rest_api_productos.services.PedidoService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/pedidos")
public class PedidoController {


    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PedidoMapper pedidoMapper;


    @GetMapping("/")
    public List<PedidoDTO> listaPedidos() {
        return pedidoService.listaPedidos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPedidoPorId(@PathVariable Long id) {
        PedidoDTO pedidoDTO = new PedidoDTO();
        Map<String, Object> response = new HashMap<>();



        try {
            pedidoDTO = pedidoService.buscarPedidoPorId(id);
        } catch (Exception e) {
            response.put("mensaje", "Error al obtener un pedido");
            response.put("error", e.getMessage());
        }

        response.put("mensaje", "pedido obtenido con éxito");
        response.put("pedido", pedidoDTO);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }


    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPedido(@RequestBody Pedido pedido, BindingResult result, @PathVariable Long id) {
        PedidoDTO pedidoDTO = new PedidoDTO();
        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()) {
            List<String> errors = new ArrayList<>();
            for(FieldError err : result.getFieldErrors()) {
                errors.add(err.getDefaultMessage());
            }

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            pedidoDTO = pedidoService.buscarPedidoPorId(id);
            pedido = pedidoMapper.toEntity(pedidoDTO);
            pedidoService.actualizarPedido(pedido);
        } catch (Exception e) {
            response.put("mensaje", "Error al actualizar el pedido");
            response.put("error", e.getMessage());
        }

        response.put("mensaje", "pedido actualizado con éxito");
        response.put("pedido", pedido);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPedido(@PathVariable Long id) {
        PedidoDTO pedidoDTO = new PedidoDTO();
        Pedido pedido = new Pedido();
        Map<String, Object> response = new HashMap<>();


        try {
            pedidoDTO = pedidoService.buscarPedidoPorId(id);
            pedido = pedidoMapper.toEntity(pedidoDTO);
            pedidoService.eliminarPedido(id);
        } catch (Exception e) {
            response.put("mensaje", "Error al eliminar el pedido");
            response.put("error", e.getMessage());
        }

        response.put("mensaje", "pedido eliminado con éxito");
        response.put("pedido", pedido);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/recaudado")
    public ResponseEntity<?> obtenerRecaudado(@RequestBody List<Pedido> pedidos) {
        Map<String, Object> response = new HashMap<>();
        double montoRecaudado = 0;


        try {
            montoRecaudado = pedidoService.obtenerRecaudado(pedidos);
        } catch (Exception e) {
            response.put("mensaje", "Error al obtener totales de pedidos");
            response.put("error", e.getMessage());
        }
        response.put("mensaje", "totales obtenidos con éxito");
        response.put("pedido", montoRecaudado);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);


    }

    @GetMapping("{id}/monto")
    public ResponseEntity<?> montoTotalPorPedido(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        double monto = 0;



        try {
            monto = pedidoService.verMontoPedido(id);
        } catch (Exception e) {
            response.put("mensaje", "Error al obtener el monto del pedido");
            response.put("error", e.getMessage());
        }

        response.put("mensaje", "total obtenido con éxito");
        response.put("pedido", monto);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/{dni}")
    public ResponseEntity<?> verPedidosCliente(@Param("dni") String dni) {
        HashMap<Long, Double> pedidosCliente = new HashMap<>();
        Map<String, Object> response = new HashMap<>();



        try {
            pedidosCliente = pedidoService.verPedidosPorCliente(dni);
        } catch (Exception e) {
            response.put("mensaje", "Error al obtener los pedidos de un cliente");
            response.put("error", e.getMessage());
        }
        response.put("mensaje", "pedidos cliente");
        response.put("pedidos", pedidosCliente);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}/eliminar-producto")
    public ResponseEntity<?> eliminarProductoDePedido(@PathVariable Long id, String producto, @Param("cantidad") int cantidad) {
        List<PedidoItemDTO> pedidoItems = new ArrayList<>();
        PedidoDTO pedidoDTO = new PedidoDTO();
        Map<String, Object> response = new HashMap<>();


        try {
            pedidoService.eliminarProductoPedido(id, producto, cantidad);
            pedidoDTO = pedidoService.buscarPedidoPorId(id);
            pedidoItems = pedidoDTO.getProductos();

        } catch (Exception e) {
            response.put("mensaje", "Error al obtener el pedido del cliente");
            response.put("error", e.getMessage());
        }
        response.put("mensaje", "pedidos cliente");
        response.put("pedidos", pedidoItems);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    


}
