package CoinKeeper.service.account;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CoinKeeper.dto.response.AccountResponse;
import CoinKeeper.model.Account;
import CoinKeeper.repository.AccountRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImplements implements AccountService{

    @Autowired
    private AccountRepository repository;

    @Override
    public Account findById(UUID id) {
        return repository.findById(id).get();
    }

    @Override
    public AccountResponse updateBalanceLimit(UUID id, double amount) {
        Account conta = repository.findById(id).orElseThrow(() -> new RuntimeException("Conta não encontrada."));
        conta.setBalance(amount);
        return new AccountResponse(repository.save(conta));

    }
}