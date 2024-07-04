package CoinKeeper.service.transfer;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import CoinKeeper.dto.request.TransferRequest;
import CoinKeeper.dto.response.TransferSumResponse;
import CoinKeeper.dto.response.TransferResponse;
import CoinKeeper.model.Category;
import CoinKeeper.model.Account;
import CoinKeeper.model.Transfer;
import CoinKeeper.repository.CategoryRepository;
import CoinKeeper.repository.AccountRepository;
import CoinKeeper.repository.TransferRepository;
import CoinKeeper.util.TransferMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransferServiceImplements implements TransferService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private final TransferRepository transferRepository;

    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private final AccountRepository accountRepository;

    private final TransferMapper transferMapper;

    @Override
    public List<TransferResponse> findAll() {
        return transferMapper.toTransferResponse(transferRepository.findAll());
    }

    @Override
    public TransferResponse register(TransferRequest transferRequest) {
        Transfer transfer = new Transfer();
        transfer.setAccount(searchAccount(transferRequest.getAccount()));
        transfer.setAmount(transferRequest.getAmount());
        transfer.setCategory(searchCategoria(transferRequest.getCategory()));
        transfer.setDate(LocalDate.now());
        transfer.setType(transfer.getCategory().getName());

        Account account = transfer.getAccount();
        double responseUpdateBalance = account.updateBalance(transfer.getAmount());

        if (responseUpdateBalance == -1)
            return null;

        transferRepository.save(transfer);
        accountRepository.save(account);

        return new TransferResponse(transfer);
    }

    @Override
    public String deleteById(UUID id) {
        transferRepository.deleteById(id);
        return "Categoria de id (" + id + ") deletada.";
    }

    @Override
    public TransferSumResponse getTotalExpense(Transfer transfer) {
        String sql = "SELECT SUM(valor) AS somaValores " +
                "FROM transacoes " +
                "WHERE categoria_id = '" + transfer.getCategory().getId() + "' " +
                "AND conta_id = '" + transfer.getAccount().getId() + "';";

        return new TransferSumResponse(transfer.getCategory().getId(), transfer.getAccount().getId(),
                transfer.getAccount().getUser().getName(),
                jdbcTemplate.queryForObject(sql, Float.class));
    }

    private Category searchCategoria(UUID id) {
        return categoryRepository.findById(id).orElse(null);
    }

    private Account searchAccount(UUID id) {
        return accountRepository.findById(id).orElse(null);
    }

}
