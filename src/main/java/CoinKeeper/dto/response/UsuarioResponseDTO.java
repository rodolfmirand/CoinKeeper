package CoinKeeper.dto.response;

import java.util.UUID;

import CoinKeeper.model.Usuario;
import CoinKeeper.model.enums.SituacaoUsuario;
import lombok.Getter;

@Getter
public class UsuarioResponseDTO {

    private UUID id;

    private String nome;

    private String login;

    private String email;

    private String senha;

    private ContaResponseDTO conta;

    private SituacaoUsuario situacao;

    public UsuarioResponseDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.login = usuario.getLogin();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.conta = new ContaResponseDTO(usuario.getConta());
        this.situacao = usuario.getSituacao();
    }
}
