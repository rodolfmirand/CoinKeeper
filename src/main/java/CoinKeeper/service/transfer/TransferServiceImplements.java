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

    @Autowired
    private final TransferMapper transferMapper;

    @Override
    public List<TransferResponse> findAll() {
        return transferMapper.toTransferResponse(transferRepository.findAll());
    }

    @Override
    public TransferResponse register(TransferRequest transferRequest) {
        Account transferAccount = accountRepository.findById(transferRequest.getAccount()).orElse(null);
        Category transferCategory = categoryRepository.findById(transferRequest.getCategory()).orElse(null);

        Transfer transfer = new Transfer(transferRequest.getAmount(), transferAccount, transferCategory);

        if (transfer.getAccount().updateBalance(transfer.getAmount()) == -1)
            return null;

        transferRepository.save(transfer);
        accountRepository.save(transfer.getAccount());

        return new TransferResponse(transfer);
    }

    @Override
    public String deleteById(UUID id) {
        transferRepository.deleteById(id);
        return "Categoria de id (" + id + ") deletada.";
    }

    @Override
    public TransferSumResponse getTotalExpense(Transfer transfer) {
        String sql = "SELECT SUM(valor) AS soma " +
                "FROM transacoes " +
                "WHERE category_id = '" + transfer.getCategory().getId() + "' " +
                "AND account_id = '" + transfer.getAccount().getId() + "';";

        return new TransferSumResponse(transfer.getCategory().getId(), transfer.getAccount().getId(),
                transfer.getAccount().getUser().getName(),
                jdbcTemplate.queryForObject(sql, Float.class));
    }
}
