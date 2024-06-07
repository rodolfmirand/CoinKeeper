package CoinKeeper.service;

import java.util.List;
import java.util.UUID;

import dto.request.CategoriaRequestDTO;
import dto.response.CategoriaResponseDTO;

public interface CategoriaServiceImplements {

    CategoriaResponseDTO findById(UUID id);

    List<CategoriaResponseDTO> findAll();

    CategoriaResponseDTO register(CategoriaRequestDTO categoria);

    CategoriaResponseDTO update(CategoriaRequestDTO categoria, Long id);

    String delete(Long id);
    
}
