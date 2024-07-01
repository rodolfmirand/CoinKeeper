package CoinKeeper.dto.response;

import lombok.Data;

@Data
public class AuthenticationResponse {
    
    private String token;

    // TODO implementar retornar o usuario e liberacoes (authorities)

    public AuthenticationResponse(String token) {
        super();
        this.token = token;
    }
}
