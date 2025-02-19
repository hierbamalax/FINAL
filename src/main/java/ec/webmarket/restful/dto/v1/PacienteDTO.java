package ec.webmarket.restful.dto.v1;

import lombok.Data;
import java.time.LocalDate;

@Data
public class PacienteDTO {

    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private LocalDate fechaNacimiento;
    private String direccion;
    private UsuarioDTO usuario;  // Asegura que el usuario se pase correctamente
}
