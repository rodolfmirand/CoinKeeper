package CoinKeeper.service;

import java.util.List;
import java.util.UUID;

import CoinKeeper.dto.request.UsuarioRequestDTO;
import CoinKeeper.dto.response.UsuarioResponseDTO;

public interface UsuarioService {

    UsuarioResponseDTO findById(UUID id);

    List<UsuarioResponseDTO> findAll();

    UsuarioResponseDTO register(UsuarioRequestDTO usuario);

    UsuarioResponseDTO update(UsuarioRequestDTO usuario, UUID id);

    String deleteById(UUID id);
}
