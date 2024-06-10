package CoinKeeper.dto.response;

import java.time.LocalDate;
import java.util.UUID;

import CoinKeeper.model.Conta;
import CoinKeeper.model.Transacao;
import lombok.Getter;

@Getter
public class TransacaoResponseDTO {
    
    private UUID id;

    private String tipo;

    private LocalDate data;

    private double valor;

    private String descricao;

    private Conta conta;

    private CategoriaResponseDTO categoria;

    public TransacaoResponseDTO(Transacao transacao){
        this.id = transacao.getId();
        this.tipo = transacao.getTipo();
        this.data = transacao.getData();
        this.valor = transacao.getValor();
        this.descricao = transacao.getDescricao();
        this.conta = transacao.getConta();
        this.categoria = new CategoriaResponseDTO(transacao.getCategoria());
    }
}
