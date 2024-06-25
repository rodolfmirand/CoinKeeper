package CoinKeeper.service.usuario;

import java.util.List;
import java.util.UUID;

import CoinKeeper.dto.request.UsuarioRequestDTO;
import CoinKeeper.dto.response.UsuarioResponseDTO;

public interface UsuarioService {

    UsuarioResponseDTO findById(UUID id);

    List<UsuarioResponseDTO> findAll();

    boolean verifyLogin(String login);

    boolean verifyEmail(String email);

    UsuarioResponseDTO register(UsuarioRequestDTO usuario);

    String registerNewUser(UsuarioRequestDTO usuario);

    UsuarioResponseDTO update(UsuarioRequestDTO usuario, UUID id);

    String deleteById(UUID id);
}
