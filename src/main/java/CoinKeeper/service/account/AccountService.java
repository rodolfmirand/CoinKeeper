package CoinKeeper.service.account;

import java.util.UUID;

import CoinKeeper.dto.response.AccountResponse;
import CoinKeeper.model.Account;

public interface AccountService {
    
    Account findById(UUID id);

    AccountResponse updateBalanceLimit(UUID id, double amount);
}
