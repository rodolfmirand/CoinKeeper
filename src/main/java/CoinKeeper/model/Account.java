package CoinKeeper.model;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Entity
@Data
@Table(name = "contas")
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_usuario")
    private User user;

    @Column(name = "saldo")
    private double balance;

    @Builder
    public Account(User user) {
        this.balance = 0.0;
        this.user = user;
    }

    @Builder
    public Account() {
    }

    public Double updateBalance(double amount) {
        if (amount > this.balance)
            return -1d;

        double newBalance = this.balance - amount;
        this.setBalance(newBalance);
        return newBalance;
    }
}
