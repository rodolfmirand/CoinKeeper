package CoinKeeper.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
@Table(name = "categorias")
@Inheritance(strategy = InheritanceType.JOINED)
@Builder
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

    @Column(name = "descricao", unique = true)
    private String descricao;

    @OneToMany
    private List<Transacao> transacao;

    @Builder
    public Categoria(String nome, String descricao, List<Transacao> transacao) {
        this.nome = nome;
        this.descricao = descricao;
        this.transacao = transacao;
    }

    @Builder
    public Categoria() {
    }
}
