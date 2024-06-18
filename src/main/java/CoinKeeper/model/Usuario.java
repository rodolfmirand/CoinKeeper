package CoinKeeper.model;

import java.util.UUID;

import CoinKeeper.model.enums.SituacaoUsuario;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
@Table(name = "usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "senha", nullable = false, unique = true)
    private String senha;

    @OneToOne(cascade = CascadeType.ALL)
    private Conta conta;

    @Enumerated(EnumType.STRING)
    private SituacaoUsuario situacao;

    @Builder
    public Usuario(String nome, String login, String email, String senha, Conta conta, SituacaoUsuario situacao) {
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.senha = senha;
        this.conta = conta;
        this.situacao = situacao;
    }

    @Builder
    public Usuario() {
    }
}
