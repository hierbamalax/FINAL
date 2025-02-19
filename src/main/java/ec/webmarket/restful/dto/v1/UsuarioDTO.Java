package ec.webmarket.restful.dto.v1;

import lombok.Data;

@Data
public class UsuarioDTO {
    private Long id;
    private String username;
    private String password;
    private String tipoUsuario;
}
