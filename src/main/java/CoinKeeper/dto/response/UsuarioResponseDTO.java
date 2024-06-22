package CoinKeeper.dto.response;

import java.util.UUID;

import CoinKeeper.model.Usuario;
import CoinKeeper.model.enums.SituacaoUsuario;
import lombok.Getter;

@Getter
public class UsuarioResponseDTO {

    private String message;

    private UUID id;

    private String nome;

    private String login;

    private String email;

    private String senha;

    private ContaResponseDTO conta;

    private SituacaoUsuario situacao;

    public UsuarioResponseDTO(Usuario usuario) {
        this.message = "Usuário cadastrado!";
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.login = usuario.getLogin();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.conta = new ContaResponseDTO(usuario.getConta());
        this.situacao = usuario.getSituacao();
    }

    public UsuarioResponseDTO(String message) {
        this.message = message;
        this.id = null;
        this.nome = null;
        this.login = null;
        this.email = null;
        this.senha = null;
        this.conta = null;
        this.situacao = null;
    }
}
