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
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Column(name = "tipo", nullable = false)
    private String type;

    @Column(name = "data", nullable = false)
    private LocalDate date;

    @Column(name = "valor", nullable = false)
    private double amount;

    @Column(name = "descricao")
    private String description;

    @ManyToOne
    private Account account;

    @ManyToOne
    private Category category;

    @Builder
    public Transfer(double amount, Account account, Category category) {
        this.date = LocalDate.now();
        this.amount = amount;
        this.account = account;
        this.category = category;
        this.type = category.getName();
    }

    @Builder
    public Transfer() {
    }

    @Builder
    public Transfer(UUID id, String type, LocalDate date, double amount, String description, Account account, Category category) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.account = account;
        this.category = category;
    }
}
