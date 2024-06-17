package CoinKeeper.dto.response;

import lombok.Data;

@Data
public class AuthenticationResponseDTO {

    private String token;

    // TODO implementar retornar o usuario e liberacoes (authorities)

    public AuthenticationResponseDTO(String token) {
        super();
        this.token = token;
    }
}
