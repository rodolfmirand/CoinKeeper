package CoinKeeper.dto.request;

import java.util.UUID;

import lombok.Getter;

@Getter
public class TransferRequest {
    
    private double amount;

    private UUID account;

    private UUID category;

}
