package CoinKeeper.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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

    @Autowired
    private final CategoriaRepository categoriaRepository;
    private JdbcTemplate jdbcTemplate;

    private final CategoriaMapper categoriaMapper;

    @Override
    public CategoriaResponseDTO findById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
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
    public int deleteById(UUID id) {
        String sql = "DELETE FROM categorias WHERE id = ?;"; 
        return jdbcTemplate.update(sql, id);
    }

}
