package CoinKeeper.dto.response;

import java.util.UUID;

import lombok.Getter;

@Getter
public class TransferSumResponse {

    private String name;

    private UUID id_account;

    private UUID id_category;

    private double amountSum;

    public TransferSumResponse(UUID id_category, UUID id_account, String name, double amountSum) {
        this.id_category = id_category;
        this.name = name;
        this.id_account = id_account;
        this.amountSum = amountSum;
    }
}
