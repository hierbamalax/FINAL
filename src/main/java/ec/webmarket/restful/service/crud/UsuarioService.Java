package ec.webmarket.restful.service.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import ec.webmarket.restful.domain.Usuario;
import ec.webmarket.restful.dto.v1.UsuarioDTO;
import ec.webmarket.restful.persistence.UsuarioRepository;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    private ModelMapper modelMapper = new ModelMapper();

    public UsuarioDTO register(UsuarioDTO dto) {
        Usuario usuario = modelMapper.map(dto, Usuario.class);
        usuario.setPassword(encryptPassword(dto.getPassword())); // Hash password before saving
        return modelMapper.map(repository.save(usuario), UsuarioDTO.class);
    }

    public Optional<UsuarioDTO> findByUsername(String username) {
        return repository.findByUsername(username).map(user -> modelMapper.map(user, UsuarioDTO.class));
    }

    public boolean authenticate(String username, String password) {
        Optional<Usuario> userOpt = repository.findByUsername(username);
        return userOpt.isPresent() && checkPassword(password, userOpt.get().getPassword());
    }

    public void updatePassword(Long id, String newPassword) {
        Usuario usuario = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setPassword(encryptPassword(newPassword));
        repository.save(usuario);
    }

    private String encryptPassword(String password) {
        return password; // Replace with actual encryption logic
    }

    private boolean checkPassword(String rawPassword, String encryptedPassword) {
        return rawPassword.equals(encryptedPassword); // Replace with actual password validation
    }
}
