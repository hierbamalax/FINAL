package ec.webmarket.restful.dto.v1;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PacienteDTO {

    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private LocalDate fechaNacimiento;
    private String direccion;
}
