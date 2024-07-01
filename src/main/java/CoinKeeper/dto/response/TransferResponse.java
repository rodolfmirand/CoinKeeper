package CoinKeeper.dto.response;

import java.time.LocalDate;
import java.util.UUID;

import CoinKeeper.model.Transfer;
import lombok.Getter;

@Getter
public class TransferResponse {
    
    private UUID id;

    private String type;

    private LocalDate date;

    private double amount;

    private AccountResponse accountResponse;

    private CategoryResponse categoryResponse;

    public TransferResponse(Transfer transfer){
        this.id = transfer.getId();
        this.type = transfer.getType();
        this.date = transfer.getDate();
        this.amount = transfer.getAmount();
        this.accountResponse = new AccountResponse(transfer.getAccount());
        this.categoryResponse = new CategoryResponse(transfer.getCategory());
    }
}
