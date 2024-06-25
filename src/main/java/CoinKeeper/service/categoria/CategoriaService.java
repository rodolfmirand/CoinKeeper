package CoinKeeper.service.categoria;

import java.util.List;
import java.util.UUID;

import CoinKeeper.dto.request.CategoriaRequestDTO;
import CoinKeeper.dto.request.CategoriaUpdateRequestDTO;
import CoinKeeper.dto.response.CategoriaResponseDTO;
import CoinKeeper.model.Categoria;

public interface CategoriaService {

    CategoriaResponseDTO findById(UUID id);

    Categoria findByIdConta(UUID id);

    List<CategoriaResponseDTO> findAll();

    CategoriaResponseDTO register(CategoriaRequestDTO categoria);

    CategoriaResponseDTO update(CategoriaUpdateRequestDTO categoria, UUID id);

    String deleteById(UUID id);
    
}
