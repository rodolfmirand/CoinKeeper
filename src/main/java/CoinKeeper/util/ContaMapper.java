package CoinKeeper.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import CoinKeeper.model.Conta;
import dto.response.ContaResponseDTO;

@Component
public class ContaMapper {
    
    public List<ContaResponseDTO> toContasDTO(List<Conta> contas) {
        return contas.stream().map(ContaResponseDTO::new).collect(Collectors.toList());
    }
}
