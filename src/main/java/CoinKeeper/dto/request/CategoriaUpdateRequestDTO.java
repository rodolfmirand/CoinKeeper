package CoinKeeper.dto.request;

import java.util.UUID;

import lombok.Getter;

@Getter
public class CategoriaUpdateRequestDTO {

    private UUID id;

    private String nome;

    private String descricao;
}
