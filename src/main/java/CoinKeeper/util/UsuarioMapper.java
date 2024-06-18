package CoinKeeper.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import CoinKeeper.dto.request.UsuarioRequestDTO;
import CoinKeeper.dto.response.UsuarioResponseDTO;
import CoinKeeper.model.Usuario;

@Component
public class UsuarioMapper {

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public Usuario toUsuario(UsuarioRequestDTO userDTO) {
        return Usuario.builder()
                .nome(userDTO.getNome())
                .login(userDTO.getLogin())
                .email(userDTO.getEmail())
                .senha(passwordEncoder.encode(userDTO.getSenha()))
                .build();
    }

    public UsuarioResponseDTO toUsuarioResponseDTO(Usuario user) {
        return new UsuarioResponseDTO(user);
    }

    public List<UsuarioResponseDTO> toUsuariosDTO(List<Usuario> users) {
        return users.stream().map(UsuarioResponseDTO::new).collect(Collectors.toList()); 
    }

    public void updateUsuario(Usuario user, UsuarioRequestDTO userDTO) {
        user.setNome(userDTO.getNome());
        user.setLogin(userDTO.getLogin());
        user.setEmail(userDTO.getEmail());
        user.setSenha(user.getSenha());
    }
}
