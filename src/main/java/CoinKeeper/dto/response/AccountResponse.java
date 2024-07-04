package CoinKeeper.dto.response;

import java.util.UUID;

import CoinKeeper.model.Account;
import lombok.Getter;

@Getter
public class AccountResponse {

    private UUID id_account;

    private String user;

    private double balance;

    public AccountResponse(Account account) {
        this.id_account = account.getId();
        this.balance = account.getBalance();
        this.user = account.getUser().getName();
    }
}
