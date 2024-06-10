package CoinKeeper.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CoinKeeper.dto.request.CategoriaRequestDTO;
import CoinKeeper.dto.response.CategoriaResponseDTO;
import CoinKeeper.model.Categoria;
import CoinKeeper.repository.CategoriaRepository;
import CoinKeeper.util.CategoriaMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImplements implements CategoriaService {

    @Autowired
    private final CategoriaRepository categoriaRepository;

    private final CategoriaMapper categoriaMapper;

    @Override
    public CategoriaResponseDTO findById(UUID id) {
        return categoriaMapper.toCategoriaResponseDTO(categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada do banco de dados.")));
    }

    @Override
    public List<CategoriaResponseDTO> findAll() {
        return categoriaMapper.toCategoriasDTO(categoriaRepository.findAll());
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
    public String deleteById(UUID id) {
        categoriaRepository.deleteById(id);
        return "Categoria de id (" + id + ") deletada.";
    }

}
