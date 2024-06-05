package CoinKeeper.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "contas")
@Getter
@SuperBuilder
public class Conta extends Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "id_usuario", unique = true)
    private Long id_usuario;

    @Column(name = "saldo")
    private double saldo;
    
    public Conta(Usuario user) {
        super(null);
        this.saldo = 0.0;
        this.id_usuario = user.getId();
    }

}
