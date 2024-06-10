package CoinKeeper.service;

import java.util.List;

import CoinKeeper.dto.request.UsuarioRequestDTO;
import CoinKeeper.dto.response.UsuarioResponseDTO;

public interface UsuarioService {

    UsuarioResponseDTO findById(Long id);

    List<UsuarioResponseDTO> findAll();

    UsuarioResponseDTO register(UsuarioRequestDTO usuario);

    UsuarioResponseDTO update(UsuarioRequestDTO usuario, Long id);

    String delete(Long id);
}
