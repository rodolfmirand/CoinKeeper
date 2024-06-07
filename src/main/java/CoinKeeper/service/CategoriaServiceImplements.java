package CoinKeeper.service;

import java.util.UUID;

import dto.response.CategoriaResponseDTO;

public interface CategoriaServiceImplements {

    CategoriaResponseDTO findById(UUID id);

    List<CategoriaResponseDTO> findAll();

    CategoriaResponseDTO register()
    
}
