package CoinKeeper.dto.response;

import java.util.UUID;

import lombok.Getter;

@Getter
public class SomaTransacoesResponseDTO {

    private UUID categoria;

    private UUID conta;

    private double somaValores;

    public SomaTransacoesResponseDTO(UUID categoria, UUID conta, double somaValores ) {
        this.categoria = categoria;
        this.conta = conta;
        this.somaValores = somaValores;
    }
}
