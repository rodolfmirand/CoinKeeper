package CoinKeeper.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import CoinKeeper.dto.response.TransacaoResponseDTO;
import CoinKeeper.model.Transacao;

@Component
public class TransacaoMapper {
    
    public List<TransacaoResponseDTO> toTransacoesResponseDTO(List<Transacao> transacoes){
        return transacoes.stream().map(TransacaoResponseDTO::new).collect(Collectors.toList());
    }
}