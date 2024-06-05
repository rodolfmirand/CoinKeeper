package dto.response;

import CoinKeeper.model.Usuario;
import lombok.Getter;

@Getter
public class UsuarioResponseDTO {

    private Long id;

    private String nome;

    private String email;

    private String senha;

    public UsuarioResponseDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }

}
