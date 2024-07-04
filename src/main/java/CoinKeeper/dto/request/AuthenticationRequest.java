package CoinKeeper.dto.request;

import lombok.Getter;

@Getter
public class AuthenticationRequest {
    
    private String login;

    private String password;
}
