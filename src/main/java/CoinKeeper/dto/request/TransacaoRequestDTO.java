package CoinKeeper.dto.request;

import java.time.LocalDate;

import CoinKeeper.model.Categoria;
import CoinKeeper.model.Conta;
import lombok.Getter;

@Getter
public class TransacaoRequestDTO {
    
    private String tipo;

    private LocalDate data;

    private double valor;

    private String descricao;

    private Conta conta;

    private Categoria categoria;

}
