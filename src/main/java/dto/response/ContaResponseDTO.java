package dto.response;

import CoinKeeper.model.Conta;
import lombok.Getter;

@Getter
public class ContaResponseDTO {

    private Long id;

    private Long id_usuario;

    private double saldo;

    public ContaResponseDTO(Conta conta) {
        this.id = conta.getId();
        this.id_usuario = conta.getId_usuario();
        this.saldo = conta.getSaldo();
    }
}
