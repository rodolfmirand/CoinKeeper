package dto.response;

import java.util.UUID;

import CoinKeeper.model.Conta;
import CoinKeeper.model.Usuario;
import lombok.Getter;

@Getter
public class UsuarioResponseDTO {

    private UUID id;

    private String nome;

    private String email;

    private String senha;

    private ContaResponseDTO conta;

    public UsuarioResponseDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.conta = new ContaResponseDTO(usuario.getConta());
    }
}
