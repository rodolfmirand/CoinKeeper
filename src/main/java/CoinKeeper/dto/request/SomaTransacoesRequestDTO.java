package CoinKeeper.dto.request;

import java.util.UUID;

import lombok.Getter;

@Getter
public class SomaTransacoesRequestDTO {
    
    private UUID conta;

    private UUID categoria;
}
