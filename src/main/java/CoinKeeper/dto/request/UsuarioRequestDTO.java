package CoinKeeper.dto.request;

import CoinKeeper.model.enums.SituacaoUsuario;
import lombok.Getter;

@Getter
public class UsuarioRequestDTO {
    
    private String nome;

    private String login;

    private String email;

    private String senha;

    private SituacaoUsuario situacao;

}
