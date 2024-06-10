package CoinKeeper.dto.request;

import java.util.UUID;

import lombok.Getter;

@Getter
public class TransacaoRequestDTO {
    
    private double valor;

    private UUID conta;

    private UUID categoria;

}
