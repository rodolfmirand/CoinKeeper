package dto.response;

import java.util.UUID;

import CoinKeeper.model.Categoria;
import lombok.Getter;

@Getter
public class CategoriaResponseDTO {
    
    private UUID id;

    private String nome;

    private String descricao;

    public CategoriaResponseDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.descricao = categoria.getDescricao();
    }

}
