package CoinKeeper.dto.response;

import java.util.UUID;

import lombok.Getter;

@Getter
public class SomaTransacoesResponseDTO {

    private UUID categoria;

    private UUID conta;

    private double somaValores;

    public SomaTransacoesResponseDTO(UUID categoria, double somaValores, UUID conta) {
        this.categoria = categoria;
        this.somaValores = somaValores;
        this.conta = conta;
    }
}
