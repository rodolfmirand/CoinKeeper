package CoinKeeper.dto.request;

import java.util.UUID;

import lombok.Getter;

@Getter
public class UpdateLimiteRequestDTO {
    
    private UUID id_conta;
    
    private double valor;

}
