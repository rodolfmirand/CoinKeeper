package CoinKeeper.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
@Table(name = "transacoes")
@Builder
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Column(name = "valor", nullable = false)
    private double valor;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    private Conta conta;

    @ManyToOne
    private Categoria categoria;

    @Builder
    public Transacao(double valor, String descricao, Conta conta, Categoria categoria) {
        this.data = LocalDate.now();
        this.valor = valor;
        this.descricao = descricao;
        this.conta = conta;
        this.categoria = categoria;
    }

    @Builder
    public Transacao() {
    }
}
