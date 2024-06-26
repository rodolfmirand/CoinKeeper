package CoinKeeper.dto.response;

import java.util.UUID;

import lombok.Getter;

@Getter
public class SomaTransacoesResponseDTO {

    private String nome;

    private UUID conta;

    private UUID categoria;

    private double somaValores;

    public SomaTransacoesResponseDTO(UUID categoria, UUID conta, String nome, double somaValores) {
        this.categoria = categoria;
        this.nome = nome;
        this.conta = conta;
        this.somaValores = somaValores;
    }
}
