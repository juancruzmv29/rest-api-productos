package restapi.example.rest_api_productos.controllers;

import org.hibernate.tool.schema.internal.ExceptionHandlerCollectingImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import restapi.example.rest_api_productos.dtos.ClienteDTO;
import restapi.example.rest_api_productos.dtos.ClienteResumenDTO;
import restapi.example.rest_api_productos.mappers.ClienteMapper;
import restapi.example.rest_api_productos.models.Cliente;
import restapi.example.rest_api_productos.services.ClienteService;

import java.util.*;

@RestController
@RequestMapping(path = "/api/clientes")
public class ClienteController {


    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteMapper clienteMapper;




    @GetMapping("/")
    public List<ClienteResumenDTO> listaClientes() {
        return clienteService.mostrarClientes();
    }

    @GetMapping("/{dni}")
    public ResponseEntity<?> obtenerCliente(@PathVariable String dni) {
        ClienteDTO clienteDTO = null;
        Map<String, Object> response = new HashMap<>();


        try {
            clienteDTO = clienteService.obtenerCliente(dni);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al querer obtener el cliente");
            response.put("error", e.getMessage());
        }
        response.put("mensaje", "cliente obtenido con exito");
        response.put("cliente", clienteDTO);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.FOUND);
    }

    @PutMapping("/{dni}")
    public ResponseEntity<?> actualizarCliente(@RequestBody Cliente cliente, @PathVariable String dni, BindingResult result) {
        ClienteDTO clienteDTO = null;
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
            clienteDTO = clienteService.obtenerCliente(dni);
            cliente = clienteMapper.toEntity(clienteDTO);
            clienteService.actualizarCliente(cliente);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al querer actualizar el cliente");
            response.put("cliente", clienteDTO);
        }

        response.put("mensaje", "cliente actualizado con éxito");
        response.put("cliente", cliente);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<?> eliminarCliente(@PathVariable String dni) {
        ClienteDTO clienteDTO = null;
        Cliente cliente = null;
        Map<String, Object> response = new HashMap<>();


        try {
            clienteDTO = clienteService.obtenerCliente(dni);
            cliente = clienteMapper.toEntity(clienteDTO);
            clienteService.darDeBajaCliente(dni);
            clienteService.eliminarCliente(cliente);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al querer eliminar el cliente");
            response.put("cliente", cliente);
            return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        response.put("mensaje", "cliente eliminado con éxito");
        response.put("cliente", cliente);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }



}
