package CoinKeeper.dto.request;

import java.util.UUID;

import lombok.Getter;

@Getter
public class TransferSumRequest {
    
    private UUID account;

    private UUID category;
}
