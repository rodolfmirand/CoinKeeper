package CoinKeeper.dto.response;

import java.util.UUID;

import CoinKeeper.model.Conta;
import lombok.Getter;

@Getter
public class ContaResponseDTO {

    private UUID id;

    private double saldo;

    public ContaResponseDTO(Conta conta) {
        this.id = conta.getId();
        this.saldo = conta.getSaldo();
    }
}
