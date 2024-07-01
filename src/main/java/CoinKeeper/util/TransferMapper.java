package CoinKeeper.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import CoinKeeper.dto.request.TransferSumRequest;
import CoinKeeper.dto.response.TransferResponse;
import CoinKeeper.model.Transfer;
import CoinKeeper.service.account.AccountService;
import CoinKeeper.service.category.CategoryService;

@Component
public class TransferMapper {

    @Autowired
    private AccountService accountService;

    @Autowired
    private CategoryService categoryService;
    
    public List<TransferResponse> toTransferResponse(List<Transfer> transfersList){
        return transfersList.stream().map(TransferResponse::new).collect(Collectors.toList());
    }

    public Transfer transferSumRequestToTransfer(TransferSumRequest transferSumRequest) {
        return Transfer.builder()
                .account(accountService.findById(transferSumRequest.getAccount()))
                .category(categoryService.findByIdAccount(transferSumRequest.getCategory()))
                .build();
    }
}