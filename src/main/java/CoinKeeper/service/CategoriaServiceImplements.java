package CoinKeeper.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import CoinKeeper.model.Categoria;
import CoinKeeper.repository.CategoriaRepository;
import CoinKeeper.util.CategoriaMapper;
import dto.request.CategoriaRequestDTO;
import dto.response.CategoriaResponseDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImplements implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    private final CategoriaMapper categoriaMapper;

    @Override
    public CategoriaResponseDTO findById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<CategoriaResponseDTO> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public CategoriaResponseDTO register(CategoriaRequestDTO categoria) {
        Categoria cat = categoriaMapper.toCategoria(categoria);
        return categoriaMapper.toCategoriaResponseDTO(categoriaRepository.save(cat));
    }

    @Override
    public CategoriaResponseDTO update(CategoriaRequestDTO categoria, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public String delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
