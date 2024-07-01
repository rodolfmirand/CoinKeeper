package CoinKeeper.service.transfer;

import java.util.List;
import java.util.UUID;

import CoinKeeper.dto.request.TransferRequest;
import CoinKeeper.dto.response.TransferSumResponse;
import CoinKeeper.dto.response.TransferResponse;
import CoinKeeper.model.Transfer;

public interface TransferService {

    List<TransferResponse> findAll();

    TransferResponse register(TransferRequest transfer);

    String deleteById(UUID id);

    TransferSumResponse getTotalExpense(Transfer transfer);
}
