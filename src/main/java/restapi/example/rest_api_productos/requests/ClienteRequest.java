package restapi.example.rest_api_productos.requests;
import jakarta.validation.constraints.NotBlank;

public record ClienteRequest(
        @NotBlank String nombre,
        @NotBlank String password
){
}
