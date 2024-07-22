package CoinKeeper.service.transfer;

import CoinKeeper.dto.request.TransferRequest;
import CoinKeeper.dto.response.TransferResponse;
import CoinKeeper.model.Account;
import CoinKeeper.model.Category;
import CoinKeeper.model.Transfer;
import CoinKeeper.model.user.User;
import CoinKeeper.repository.AccountRepository;
import CoinKeeper.repository.CategoryRepository;
import CoinKeeper.repository.TransferRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.mockito.Mockito.*;

class TransferServiceImplementsTest {

    @Mock
    private TransferRepository transferRepository;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Autowired
    @InjectMocks
    private TransferServiceImplements transferService;

    //executa antes de todos os testes
    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Deve criar a transação com sucesso")
    void registerSuccess() {
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.setAmount(20);

        Account account = new Account();
        account.setBalance(100);

        Category category = new Category();
        category.setName("Rolês");

        when(accountRepository.findById(transferRequest.getAccount())).thenReturn(Optional.of(account));
        when(categoryRepository.findById(transferRequest.getCategory())).thenReturn(Optional.of(category));

        Transfer transfer = new Transfer(transferRequest.getAmount(), account, category);

        verify(transferRepository, times(1)).save(any());
        verify(accountRepository, times(1)).save(any());

    }

    @Test
    @DisplayName("Não deve criar a transação")
    void registerFailed() {
    }
}