package CoinKeeper.dto.request;

import java.util.UUID;

import lombok.Getter;

@Getter
public class BalanceLimitUpdateRequest {
    
    private UUID id_account;
    
    private double amount;

}
