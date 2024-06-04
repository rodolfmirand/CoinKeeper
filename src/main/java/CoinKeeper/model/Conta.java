package CoinKeeper.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contas")
@Setter
@Getter
public class Conta extends Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "id_ususario", nullable = false, unique = true)
    private Long id_usuario;

    @Column(name = "saldo")
    private double saldo;

    private Usuario usuario;

    @Builder
    public Conta(String nome, String email, String senha, Usuario usuario) {
        super(nome, email, senha);
        this.usuario = usuario;
        this.id_usuario = usuario.getId();
        this.saldo = 0.0;
    }

}
