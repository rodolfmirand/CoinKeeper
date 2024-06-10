package CoinKeeper.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import CoinKeeper.dto.request.CategoriaRequestDTO;
import CoinKeeper.dto.response.CategoriaResponseDTO;
import CoinKeeper.model.Categoria;

@Component
public class CategoriaMapper {
    
    public Categoria toCategoria(CategoriaRequestDTO catDTO){
        return Categoria.builder()
                    .nome(catDTO.getNome())
                    .descricao(catDTO.getDescricao())
                    .build();
    }

    public CategoriaResponseDTO toCategoriaResponseDTO(Categoria cat) {
        return new CategoriaResponseDTO(cat);
    }

    public List<CategoriaResponseDTO> toCategoriasDTO(List<Categoria> cats) {
        return cats.stream().map(CategoriaResponseDTO::new).collect(Collectors.toList());
    }
}
