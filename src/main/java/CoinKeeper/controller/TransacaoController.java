package CoinKeeper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CoinKeeper.dto.request.SomaTransacoesRequestDTO;
import CoinKeeper.dto.request.TransacaoRequestDTO;
import CoinKeeper.dto.response.SomaTransacoesResponseDTO;
import CoinKeeper.dto.response.TransacaoResponseDTO;
import CoinKeeper.service.TransacaoService;
import CoinKeeper.util.TransacaoMapper;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/transacoes")
@RequiredArgsConstructor
public class TransacaoController {

    @Autowired
    private final TransacaoService service;

    private TransacaoMapper mapper;

    @GetMapping
    public ResponseEntity<List<TransacaoResponseDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/totais")
    public ResponseEntity<List<SomaTransacoesResponseDTO>> getTotalGasto(@RequestBody SomaTransacoesRequestDTO request) {
        return ResponseEntity.ok().body(service.getTotalGasto(mapper.totalRequestToTransacao(request)));
    }

    @PostMapping
    public ResponseEntity<TransacaoResponseDTO> register(@RequestBody TransacaoRequestDTO transRequestDTO){
        return ResponseEntity.ok().body(service.register(transRequestDTO));
    }
}
