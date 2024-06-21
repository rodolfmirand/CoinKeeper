package CoinKeeper.service;

import java.util.UUID;

import CoinKeeper.dto.response.ContaResponseDTO;
import CoinKeeper.model.Conta;

public interface ContaService {
    
    Conta findById(UUID id);

    ContaResponseDTO uptadeLimite(UUID id, double valor);
}
