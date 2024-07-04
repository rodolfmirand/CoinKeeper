package CoinKeeper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CoinKeeper.dto.request.TransferSumRequest;
import CoinKeeper.dto.request.TransferRequest;
import CoinKeeper.dto.response.TransferSumResponse;
import CoinKeeper.dto.response.TransferResponse;
import CoinKeeper.service.transfer.TransferService;
import CoinKeeper.util.TransferMapper;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/coinkeeper/transacoes")
@RequiredArgsConstructor
public class TransferController {

    @Autowired
    private final TransferService service;

    @Autowired
    private TransferMapper mapper;

    @GetMapping
    public ResponseEntity<List<TransferResponse>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/total")
    public ResponseEntity<TransferSumResponse> getTotalExpense(@RequestBody TransferSumRequest transferSumRequest) {
        return ResponseEntity.ok().body(service.getTotalExpense(mapper.transferSumRequestToTransfer(transferSumRequest)));
    }

    @PostMapping
    public ResponseEntity<TransferResponse> register(@RequestBody TransferRequest transferRequest){
        return ResponseEntity.ok().body(service.register(transferRequest));
    }
}
