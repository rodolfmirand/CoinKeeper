package CoinKeeper.service;

import java.util.List;
import java.util.UUID;

import CoinKeeper.dto.request.CategoriaRequestDTO;
import CoinKeeper.dto.response.CategoriaResponseDTO;

public interface CategoriaService {

    CategoriaResponseDTO findById(UUID id);

    List<CategoriaResponseDTO> findAll();

    CategoriaResponseDTO register(CategoriaRequestDTO categoria);

    CategoriaResponseDTO update(CategoriaRequestDTO categoria, Long id);

    int deleteById(UUID id);
    
}
