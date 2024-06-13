package CoinKeeper.service;

import java.util.List;
import java.util.UUID;

import CoinKeeper.dto.request.TransacaoRequestDTO;
import CoinKeeper.dto.response.SomaTransacoesResponseDTO;
import CoinKeeper.dto.response.TransacaoResponseDTO;
import CoinKeeper.model.Transacao;

public interface TransacaoService {

    List<TransacaoResponseDTO> findAll();

    TransacaoResponseDTO register(TransacaoRequestDTO transacao);

    String deleteById(UUID id);

    SomaTransacoesResponseDTO getTotalGasto(Transacao transacao);
}
